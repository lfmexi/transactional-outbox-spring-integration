package org.lfmexi.transactional.outbox.sample.repository

import org.springframework.data.jpa.repository.JpaRepository

internal interface AccountEntityJpaRepository : JpaRepository<AccountEntity, String>
