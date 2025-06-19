package com.ryukato.practice.storage.r2dbc.mysql.user.extension

import com.ryukato.practice.core.domain.user.model.TestUser
import com.ryukato.practice.date.extension.toEpochMilli
import com.ryukato.practice.storage.r2dbc.mysql.user.entity.TestUserEntity

fun TestUserEntity.toDomainModel(): TestUser {
    return TestUser(
        instanceId = rowId,
        userId = userId,
        name = name,
        createdAt = createdAt.toEpochMilli()
    )
}
