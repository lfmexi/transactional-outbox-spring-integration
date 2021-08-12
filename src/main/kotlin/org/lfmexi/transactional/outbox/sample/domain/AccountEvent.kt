package org.lfmexi.transactional.outbox.sample.domain

import java.time.Instant

sealed class AccountEvent: DomainEvent {
    override val timestamp: Instant = Instant.now()
    abstract val account: Account
}

data class AccountCreatedEvent(
    override val id: EventId = EventId.generate(),
    override val account: Account,
    override val timestamp: Instant
) : AccountEvent()

data class AccountUpdatedEvent(
    override val id: EventId = EventId.generate(),
    override val account: Account,
    override val timestamp: Instant
) : AccountEvent()
