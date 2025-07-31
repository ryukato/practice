package com.ryukato.practice.api.eip.dispatcher

import com.ryukato.practice.api.eip.dispatcher.exception.policy.ExceptionHandlingPolicy
import com.ryukato.practice.api.eip.dispatcher.handler.message.MessageHandler
import com.ryukato.practice.api.eip.dispatcher.handler.queue.DeadLetterQueue
import com.ryukato.practice.api.eip.dispatcher.handler.queue.RetryQueue
import com.ryukato.practice.api.eip.dispatcher.handler.retry.RetryHandler
import com.ryukato.practice.api.eip.dispatcher.message.DomainMessage
import java.util.concurrent.Semaphore
import java.util.concurrent.atomic.AtomicLong
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

interface CoroutineMessageDispatcher {
    suspend fun start(scope: CoroutineScope)
}

class DefaultCoroutineMessageDispatcher(
    private val channel: ReceiveChannel<DomainMessage>,
    private val handlers: List<MessageHandler>,
    private val policy: ExceptionHandlingPolicy,
    private val commitOffset: suspend (Long) -> Unit,
    private val retryHandler: RetryHandler,
    private val deadLetterQueue: DeadLetterQueue,
    private val retryQueue: RetryQueue
) : CoroutineMessageDispatcher {
    private val lastCommittedOffset = AtomicLong(-1L)

    override suspend fun start(scope: CoroutineScope) {
        val semaphore = Semaphore(handlers.size)

        for (handler in handlers) {
            scope.launch {
                for (message in channel) {
                    if (deadLetterQueue.isRecorded(message.offset)) {
                        println("Skip DLQ’d message at offset=${message.offset}")
                        commitOffset(message.offset)
                        lastCommittedOffset.set(message.offset)
                        continue
                    }

                    semaphore.acquire()
                    launch {
                        try {
                            val result = retryHandler.withRetry(message) {
                                println("Handling message: $message")
                                handler.handle(message)
                            }

                            result.onSuccess {
                                commitOffset(message.offset)
                                lastCommittedOffset.set(message.offset)
                            }.onFailure { e ->
                                when {
                                    policy.shouldRetry(e) -> {
                                        retryQueue.enqueue(message, e)
                                        commitOffset(message.offset)
                                        lastCommittedOffset.set(message.offset)
                                    }

                                    policy.shouldStopConsuming(e) -> {
                                        println("Fatal error - stop consuming")
                                        scope.cancel("Fatal exception. Stopping dispatcher.", e)
                                    }

                                    else -> {
                                        deadLetterQueue.publish(message, e)
                                        commitOffset(message.offset)
                                        lastCommittedOffset.set(message.offset)
                                    }
                                }
                            }
                        } catch (e: Throwable) {
                            println("Dispatcher error: ${e.message}")
                            scope.cancel("Dispatcher failed", e)
                        } finally {
                            semaphore.release()
                        }
                    }
                }
            }
        }
    }
}
