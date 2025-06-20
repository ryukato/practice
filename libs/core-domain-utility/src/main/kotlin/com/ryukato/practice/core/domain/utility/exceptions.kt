package com.ryukato.practice.core.domain.utility

data class CircuitBreakerException(
    override val message: String?
): RuntimeException(message)
