package com.ryukato.practice.core.domain.common.excepion

data class ResourceNotFoundException(
    val resourceType: String,
    val resourceIdentifier: String,
) : RuntimeException("not found resource - resourceType=$resourceType, resourceIdentifier=$resourceIdentifier")
