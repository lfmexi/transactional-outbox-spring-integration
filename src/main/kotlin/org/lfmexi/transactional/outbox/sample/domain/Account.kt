package org.lfmexi.transactional.outbox.sample.domain

import java.time.Instant

data class Account constructor(
    val id: AccountId,
    val number: AccountNumber,
    val createdTimestamp: Instant,
    val modifiedTimestamp: Instant,
    override val recordedEvents: List<DomainEvent> = emptyList()
): BaseEntity()  {
    constructor(
        id: AccountId,
        number: AccountNumber
    ): this(id, number, Instant.now(), Instant.now(), emptyList())

    private fun updateWithEvent(domainEvent: DomainEvent): Account {
        return this.copy(
            recordedEvents = recordedEvents + domainEvent,
            modifiedTimestamp = domainEvent.timestamp
        )
    }

    companion object {
        fun create(number: AccountNumber): Account {
            return Account(
                id = AccountId.generate(),
                number = number
            ).let {
                it.updateWithEvent(AccountCreatedEvent(
                    account = it,
                    timestamp = it.createdTimestamp
                ))
            }
        }
    }
}
