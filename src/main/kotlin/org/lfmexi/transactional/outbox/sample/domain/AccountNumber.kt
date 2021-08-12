package org.lfmexi.transactional.outbox.sample.domain

data class AccountNumber(
    val value: String
) {
    override fun toString(): String {
        return value
    }
}
