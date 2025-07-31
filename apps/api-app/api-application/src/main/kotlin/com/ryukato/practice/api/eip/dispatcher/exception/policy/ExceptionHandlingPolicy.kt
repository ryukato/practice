package com.ryukato.practice.api.eip.dispatcher.exception.policy

import java.io.IOException
import kotlinx.coroutines.TimeoutCancellationException

interface ExceptionHandlingPolicy {
    fun shouldRetry(e: Throwable): Boolean
    fun shouldStopConsuming(e: Throwable): Boolean
}


class SeverityBasedPolicy : ExceptionHandlingPolicy {
    override fun shouldRetry(e: Throwable) =
        e is IOException || e is TimeoutCancellationException

    override fun shouldStopConsuming(e: Throwable) =
        e is IllegalStateException || e is OutOfMemoryError
}
