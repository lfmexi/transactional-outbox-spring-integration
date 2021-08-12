package org.lfmexi.transactional.outbox.sample.application

import org.lfmexi.transactional.outbox.sample.domain.Account
import org.lfmexi.transactional.outbox.sample.domain.AccountNumber

interface AccountService {
    fun create(number: AccountNumber): Account
}
