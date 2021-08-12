package org.lfmexi.transactional.outbox.sample.domain

import java.time.Instant

interface DomainEvent {
    val id: EventId
    val timestamp: Instant
}
