package org.lfmexi.transactional.outbox.sample.domain

interface AccountRepositoryAdapter {
    fun save(account: Account)
}
