package com.ryukato.practice.api.error

data class ErrorResponse(
    val requestId: String,
    val status: Int,
    val type: String,
    val title: String?,
    val instance: String?,
    val detail: String?,
    val timestamp: String,
    val properties: Map<String, String>? = emptyMap()
)
