package org.lfmexi.transactional.outbox.sample.repository

import org.lfmexi.transactional.outbox.sample.domain.Account
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "account")
internal data class AccountEntity(
    @Id
    val id: String,

    val number: String,

    val createdTimestamp: Instant,

    val modifiedTimestamp: Instant
) {
    companion object {
        fun from(account: Account): AccountEntity {
            return AccountEntity(
                id = account.id.value,
                number = account.number.value,
                createdTimestamp = account.createdTimestamp,
                modifiedTimestamp = account.modifiedTimestamp
            )
        }
    }
}
