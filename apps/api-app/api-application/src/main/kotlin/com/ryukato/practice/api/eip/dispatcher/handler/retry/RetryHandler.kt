package com.ryukato.practice.api.eip.dispatcher.handler.retry

import com.ryukato.practice.api.eip.dispatcher.message.DomainMessage

interface RetryHandler {
    suspend fun <T> withRetry(
        message: DomainMessage,
        block: suspend () -> T
    ): Result<T>
}
