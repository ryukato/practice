package com.ryukato.practice.api.eip.dispatcher

import com.ryukato.practice.api.eip.dispatcher.exception.policy.SeverityBasedPolicy
import com.ryukato.practice.api.eip.dispatcher.handler.message.MessageHandler
import com.ryukato.practice.api.eip.dispatcher.handler.queue.InMemoryDeadLetterQueue
import com.ryukato.practice.api.eip.dispatcher.handler.queue.InMemoryRetryQueue
import com.ryukato.practice.api.eip.dispatcher.handler.retry.FixedDelayIntervalRetryHandler
import com.ryukato.practice.api.eip.dispatcher.message.DomainMessage
import java.io.IOException
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class MessageDispatcherTest {
    @Test
    fun `dispatcher processes messages and handles exceptions`() = runBlocking {
        val channel = Channel<DomainMessage>(capacity = 100)

        val dispatcher = DefaultCoroutineMessageDispatcher(
            channel = channel,
            handlers = listOf(object : MessageHandler {
                override suspend fun handle(message: DomainMessage) {
                    when {
                        message.offset % 5 == 0L -> throw IOException("Temporary error")
                        message.offset % 6 == 0L -> throw RuntimeException("To dead-letter-queue")
                        message.offset % 7 == 0L -> throw IllegalStateException("Fatal error")
                        else -> println("✅ handled offset=${message.offset}")
                    }
                }
            }),
            policy = SeverityBasedPolicy(),
            commitOffset = { offset -> println("☑️ commit offset=$offset") },
            retryHandler = FixedDelayIntervalRetryHandler(3, 100),
            deadLetterQueue = InMemoryDeadLetterQueue(),
            retryQueue = InMemoryRetryQueue()
        )

        val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

        scope.launch {
            var offset = 0L
            while (isActive) {
                delay(10)
                channel.send(DomainMessage("key-$offset", "value-$offset", offset++))
            }
        }

        dispatcher.start(scope)

        delay(5.seconds)
        scope.cancel()
    }
}
