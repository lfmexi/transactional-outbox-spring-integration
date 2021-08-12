package org.lfmexi.transactional.outbox.sample.event.outbox.configuration

import org.lfmexi.transactional.outbox.sample.event.outbox.OutboxEventJPARepository
import org.lfmexi.transactional.outbox.sample.event.outbox.OutboxEventPublisher
import org.lfmexi.transactional.outbox.sample.event.outbox.PersistedOutboxEventPublisher
import org.springframework.context.annotation.Bean

class TransactionalOutboxConfiguration {
    @Bean
    internal fun outboxEventPublisher(
        outboxEventJPARepository: OutboxEventJPARepository
    ): OutboxEventPublisher {
        return PersistedOutboxEventPublisher(outboxEventJPARepository)
    }
}
