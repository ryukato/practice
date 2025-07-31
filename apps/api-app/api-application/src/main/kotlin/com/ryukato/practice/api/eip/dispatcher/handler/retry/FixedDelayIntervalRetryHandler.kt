package com.ryukato.practice.api.eip.dispatcher.handler.retry

import com.ryukato.practice.api.eip.dispatcher.message.DomainMessage
import java.util.concurrent.ConcurrentHashMap
import kotlinx.coroutines.delay

class FixedDelayIntervalRetryHandler(
    private val maxAttempts: Int,
    private val delayMillis: Long
) : RetryHandler {
    private val retryCounts = ConcurrentHashMap<String, Int>()

    override suspend fun <T> withRetry(
        message: DomainMessage,
        block: suspend () -> T
    ): Result<T> {
        val key = message.offset.toString()
        val attempts = retryCounts.getOrDefault(key, 0)

        return try {
            val result = block()
            retryCounts.remove(key)
            Result.success(result)
        } catch (e: Throwable) {
            if (attempts + 1 >= maxAttempts) {
                retryCounts.remove(key)
                Result.failure(e)
            } else {
                retryCounts[key] = attempts + 1
                delay(delayMillis)
                Result.failure(e)
            }
        }
    }
}
