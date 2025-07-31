package com.ryukato.practice.api.eip.dispatcher.handler.queue

import com.ryukato.practice.api.eip.dispatcher.message.DomainMessage
import java.util.concurrent.ConcurrentHashMap

interface DeadLetterQueue {
    suspend fun publish(message: DomainMessage, reason: Throwable)
    fun isRecorded(offset: Long): Boolean
}


class InMemoryDeadLetterQueue : DeadLetterQueue {
    private val deadSet = ConcurrentHashMap.newKeySet<Long>()
    private val messages = mutableListOf<Pair<DomainMessage, Throwable>>()

    override suspend fun publish(message: DomainMessage, reason: Throwable) {
        if (deadSet.add(message.offset)) {
            println("🔴 DLQ: offset=${message.offset}, reason=${reason.message}")
            messages.add(message to reason)
        } else {
           println("Ignore adding since already in: offset=${message.offset}")
        }
    }

    override fun isRecorded(offset: Long): Boolean = deadSet.contains(offset)
}
