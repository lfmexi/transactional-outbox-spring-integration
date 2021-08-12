package org.lfmexi.transactional.outbox.sample.domain

abstract class BaseEntity {
    abstract val recordedEvents: List<DomainEvent>
}
