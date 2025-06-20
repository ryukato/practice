package com.ryukato.practice.core.domain.utility

/*
cb:{target}:state	Circuit 상태 (OPEN, CLOSED, HALF_OPEN)
cb:{target}:failures	실패 횟수 저장 (INCR로 증가)
cb:{target}:last-failure-ts	최근 실패 시간 (백오프 등용)
 */
interface DistributedCircuitBreaker {
    suspend fun <T> execute(
        key: String,
        exceptionClassifier: ExceptionClassifier = DefaultExceptionClassifier(),
        supplier: suspend () -> T
    ): T

    suspend fun isCallPermitted(key: String): Boolean
    suspend fun currentState(key: String): CircuitBreakerState
    suspend fun successCount(key: String): Long
    suspend fun failureCount(key: String): Long
}
