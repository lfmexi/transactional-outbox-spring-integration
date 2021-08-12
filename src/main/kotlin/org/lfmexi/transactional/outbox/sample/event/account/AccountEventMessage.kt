package org.lfmexi.transactional.outbox.sample.event.account

import org.lfmexi.transactional.outbox.sample.domain.Account
import org.lfmexi.transactional.outbox.sample.domain.AccountEvent
import java.time.Instant

internal data class AccountEventMessage(
    val eventId: String,
    val eventType: EnumeratedEventType,
    val eventTimestamp: Instant,
    val accountPayload: AccountPayload
) {
    companion object {
        fun from(accountEvent: AccountEvent): AccountEventMessage {
            return AccountEventMessage(
                eventId = accountEvent.id.value,
                eventType = EnumeratedEventType.from(accountEvent),
                eventTimestamp = accountEvent.timestamp,
                accountPayload = AccountPayload.from(accountEvent.account)
            )
        }
    }
}

internal data class AccountPayload(
    val id: String,
    val number: String,
    val createdTimestamp: Instant,
    val modifiedTimestamp: Instant
) {
    companion object {
        fun from(account: Account): AccountPayload {
            return AccountPayload(
                id = account.id.value,
                number = account.number.value,
                createdTimestamp = account.createdTimestamp,
                modifiedTimestamp = account.modifiedTimestamp
            )
        }
    }
}
