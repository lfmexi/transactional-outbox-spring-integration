package org.lfmexi.transactional.outbox.sample.event.outbox

internal class PersistedOutboxEventPublisher(
    private val outboxEventJPARepository: OutboxEventJPARepository
): OutboxEventPublisher {
    override fun publish(event: OutboxEvent) {
        outboxEventJPARepository.save(
            OutboxEventEntity.from(event)
        )
    }
}
