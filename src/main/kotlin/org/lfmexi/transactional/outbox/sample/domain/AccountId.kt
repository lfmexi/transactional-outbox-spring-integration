package org.lfmexi.transactional.outbox.sample.domain

import java.util.UUID

data class AccountId(
    val value: String
) {
    override fun toString(): String {
        return value
    }

    companion object {
        fun generate(): AccountId {
            return AccountId(UUID.randomUUID().toString())
        }
    }
}
