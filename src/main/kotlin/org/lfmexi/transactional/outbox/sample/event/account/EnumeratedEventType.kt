package org.lfmexi.transactional.outbox.sample.event.account

import org.lfmexi.transactional.outbox.sample.domain.AccountCreatedEvent
import org.lfmexi.transactional.outbox.sample.domain.AccountEvent
import org.lfmexi.transactional.outbox.sample.domain.AccountUpdatedEvent

internal enum class EnumeratedEventType {
    ACCOUNT_CREATED,
    ACCOUNT_UPDATED;

    companion object {
        fun from(accountEvent: AccountEvent): EnumeratedEventType {
            return when (accountEvent) {
                is AccountCreatedEvent -> ACCOUNT_CREATED
                is AccountUpdatedEvent -> ACCOUNT_UPDATED
            }
        }
    }
}
