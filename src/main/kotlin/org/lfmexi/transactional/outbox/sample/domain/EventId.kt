package org.lfmexi.transactional.outbox.sample.domain

import java.util.UUID

data class EventId(
    val value: String
) {
    override fun toString(): String {
        return value
    }

    companion object {
        fun generate(): EventId {
            return EventId(UUID.randomUUID().toString())
        }
    }
}
