package org.lfmexi.transactional.outbox.sample.event.outbox

interface OutboxEventPublisher {
    fun publish(event: OutboxEvent)
}
