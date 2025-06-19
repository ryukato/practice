package com.ryukato.practice.core.domain.user.model

import com.ryukato.practice.date.extension.toEpochMilli
import java.time.LocalDateTime
import java.util.*

data class TestUser(
    val instanceId: Long = 0,
    val userId: String = UUID.randomUUID().toString(),
    val name: String,
    val createdAt: Long = LocalDateTime.now().toEpochMilli()
)
