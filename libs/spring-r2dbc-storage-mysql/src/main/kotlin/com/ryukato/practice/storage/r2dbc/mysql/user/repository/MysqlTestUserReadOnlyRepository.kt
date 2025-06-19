package com.ryukato.practice.storage.r2dbc.mysql.user.repository

import com.ryukato.practice.core.domain.user.model.TestUser
import com.ryukato.practice.core.domain.user.repository.TestUserReadOnlyRepository
import com.ryukato.practice.storage.r2dbc.mysql.user.entity.TestUserEntity
import com.ryukato.practice.storage.r2dbc.mysql.user.extension.toDomainModel
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.relational.core.query.Criteria
import org.springframework.data.relational.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class MysqlTestUserReadOnlyRepository(
    private val r2dbcEntityTemplate: R2dbcEntityTemplate,
) : TestUserReadOnlyRepository {
    override suspend fun findById(instanceId: Long): TestUser? {
        val query = Query.query(
            Criteria.where("rowId").`is`(instanceId)
        )
        return queryOneOrNull(query)
    }

    override suspend fun findByUserId(userId: String): TestUser? {
        val query = Query.query(
            Criteria.where("userId").`is`(userId)
        )
        return queryOneOrNull(query)
    }

    override suspend fun findByName(name: String): TestUser? {
        val query = Query.query(
            Criteria.where("name").`is`(name)
        )
        return queryOneOrNull(query)
    }

    private suspend fun queryOneOrNull(query: Query): TestUser? {
        return r2dbcEntityTemplate.select(TestUserEntity::class.java)
            .matching(query)
            .one()
            .map { it.toDomainModel() }
            .awaitSingleOrNull()
    }
}
