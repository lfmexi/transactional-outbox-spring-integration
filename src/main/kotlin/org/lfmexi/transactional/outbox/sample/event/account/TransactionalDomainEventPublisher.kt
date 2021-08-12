package org.lfmexi.transactional.outbox.sample.event.account

import org.lfmexi.transactional.outbox.sample.domain.BaseEntity
import org.lfmexi.transactional.outbox.sample.domain.DomainEventPublisher
import org.lfmexi.transactional.outbox.sample.event.outbox.OutboxEventPublisher
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
internal class TransactionalDomainEventPublisher(
    private val domainEventMapper: DomainEventMapper,
    private val outboxEventPublisher: OutboxEventPublisher
) : DomainEventPublisher {
    @Transactional
    override fun publishRecordedEvents(entity: BaseEntity) {
        entity.recordedEvents.map {
            domainEventMapper.createOutboxMessageFromEvent(it)
        }.forEach {
            outboxEventPublisher.publish(it)
        }
    }
}
