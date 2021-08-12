package org.lfmexi.transactional.outbox.sample.repository

import org.lfmexi.transactional.outbox.sample.domain.Account
import org.lfmexi.transactional.outbox.sample.domain.AccountRepositoryAdapter
import org.springframework.stereotype.Repository

@Repository
internal class AccountRepositoryAdapterImpl(
    private val accountEntityJpaRepository: AccountEntityJpaRepository
) : AccountRepositoryAdapter {
    override fun save(account: Account) {
        accountEntityJpaRepository.save(AccountEntity.from(account))
    }
}
