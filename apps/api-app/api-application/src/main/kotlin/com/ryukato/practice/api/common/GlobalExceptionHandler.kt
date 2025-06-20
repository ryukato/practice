package com.ryukato.practice.api.common

import com.ryukato.practice.api.error.ErrorResponse
import com.ryukato.practice.core.domain.common.excepion.ResourceNotFoundException
import java.net.URI
import java.time.Instant
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler
import org.springframework.web.server.ServerWebExchange

@RestControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [Exception::class])
    fun handleException(
        exception: ResourceNotFoundException,
        exchange: ServerWebExchange
    ): ResponseEntity<ErrorResponse> {
        val request = exchange.request
        val contentType = request.headers.contentType

        val requestId = exchange.request.id
        val httpStatus = exception.resolveHttpStatus()
        return ResponseEntity.status(httpStatus.value())
            .body(exception.toProblemDetail(exchange).toErrorResponse(requestId = requestId))
    }
}

fun ResourceNotFoundException.toProblemDetail(exchange: ServerWebExchange): ProblemDetail {
    val httpStatus = resolveHttpStatus()
    val problemDetail = buildDefaultProblemDetail(httpStatus)
    problemDetail.type = resolveTypeUri()
    problemDetail.title = resolveTitle()
    problemDetail.instance = URI.create(exchange.request.path.value())
    problemDetail.properties = mapOf("timestamp" to Instant.now())
    return problemDetail
}

internal fun ResourceNotFoundException.resolveHttpStatus(): HttpStatus = HttpStatus.NOT_FOUND
internal fun ResourceNotFoundException.resolveTypeUri(): URI = URI.create("/errors/resource-not-found")
internal fun ResourceNotFoundException.resolveTitle(): String = "NO Resource found"


internal fun ProblemDetail.toErrorResponse(requestId: String): ErrorResponse {
    return ErrorResponse(
        requestId = requestId,
        status = status,
        type = type.path,
        title = title,
        instance = instance?.path,
        detail = detail,
        timestamp = properties?.get("timestamp").toString(),
        properties = properties?.entries?.associate { (k, v) -> k to v.toString() }
    )
}


private fun ResourceNotFoundException.buildDefaultProblemDetail(httpStatus: HttpStatus): ProblemDetail {
    val problemDetail = ProblemDetail.forStatusAndDetail(
        HttpStatusCode.valueOf(httpStatus.value()),
        message
    )
    return problemDetail
}
