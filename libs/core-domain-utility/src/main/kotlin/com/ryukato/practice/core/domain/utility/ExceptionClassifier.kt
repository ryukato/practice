package com.ryukato.practice.core.domain.utility

import com.ryukato.practice.core.domain.common.excepion.ResourceNotFoundException

interface ExceptionClassifier {
    fun shouldTrip(ex: Throwable): Boolean
}

class DefaultExceptionClassifier: ExceptionClassifier {
    override fun shouldTrip(ex: Throwable): Boolean {
       return when(ex) {
           is ResourceNotFoundException -> true
           else -> false
       }
    }
}
