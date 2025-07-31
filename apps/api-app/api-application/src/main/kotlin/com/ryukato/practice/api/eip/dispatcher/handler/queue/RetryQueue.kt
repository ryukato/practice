package com.ryukato.practice.api.eip.dispatcher.handler.queue

import com.ryukato.practice.api.eip.dispatcher.message.DomainMessage

interface RetryQueue {
    suspend fun enqueue(message: DomainMessage, reason: Throwable)
}

class InMemoryRetryQueue : RetryQueue {
    private val retried = mutableListOf<Pair<DomainMessage, Throwable>>()
    override suspend fun enqueue(message: DomainMessage, reason: Throwable) {
        println("🔁 RETRY: offset=${message.offset}, reason=${reason.message}")
        retried.add(message to reason)
    }
}
