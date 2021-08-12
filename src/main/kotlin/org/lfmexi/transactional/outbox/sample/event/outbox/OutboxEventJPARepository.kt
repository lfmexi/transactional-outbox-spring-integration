package org.lfmexi.transactional.outbox.sample.event.outbox

import org.springframework.data.jpa.repository.JpaRepository

internal interface OutboxEventJPARepository : JpaRepository<OutboxEventEntity, String>
