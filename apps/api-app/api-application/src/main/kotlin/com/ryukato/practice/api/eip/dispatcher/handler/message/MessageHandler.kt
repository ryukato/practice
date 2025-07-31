package com.ryukato.practice.api.eip.dispatcher.handler.message

import com.ryukato.practice.api.eip.dispatcher.message.DomainMessage

interface MessageHandler {
    suspend fun handle(message: DomainMessage)
}
