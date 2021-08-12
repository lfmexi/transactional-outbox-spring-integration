package org.lfmexi.transactional.outbox.sample.domain

interface DomainEventPublisher {
    fun publishRecordedEvents(entity: BaseEntity)
}
