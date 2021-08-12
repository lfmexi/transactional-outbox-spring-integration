package org.lfmexi.transactional.outbox.sample.application

import org.lfmexi.transactional.outbox.sample.domain.Account
import org.lfmexi.transactional.outbox.sample.domain.AccountNumber
import org.lfmexi.transactional.outbox.sample.domain.AccountRepositoryAdapter
import org.lfmexi.transactional.outbox.sample.domain.DomainEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
internal class AccountServiceImpl(
    private val accountRepositoryAdapter: AccountRepositoryAdapter,
    private val domainEventPublisher: DomainEventPublisher
) : AccountService {
    @Transactional
    override fun create(number: AccountNumber): Account {
        val account = Account.create(
            number
        )

        accountRepositoryAdapter.save(account)
        domainEventPublisher.publishRecordedEvents(account)

        return account
    }
}
