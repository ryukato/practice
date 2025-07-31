package com.ryukato.practice.api.eip.dispatcher.message

data class DomainMessage(
    val key: String,
    val value: String,
    val offset: Long
)
