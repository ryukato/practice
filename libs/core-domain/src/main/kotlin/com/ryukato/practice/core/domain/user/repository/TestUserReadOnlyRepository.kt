package com.ryukato.practice.core.domain.user.repository

import com.ryukato.practice.core.domain.user.model.TestUser

interface TestUserReadOnlyRepository {
    suspend fun findById(instanceId: Long): TestUser?
    suspend fun findByUserId(userId: String): TestUser?
    suspend fun findByName(name: String): TestUser?
}
