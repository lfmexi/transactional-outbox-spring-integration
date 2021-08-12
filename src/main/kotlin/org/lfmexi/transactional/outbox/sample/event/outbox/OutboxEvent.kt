package org.lfmexi.transactional.outbox.sample.event.outbox

import java.time.Instant

data class OutboxEvent(
    val id: String,

    val timestamp: Instant,

    val eventType: String,

    val state: OutboxState,

    val event: String
) {
    companion object {
        fun create(id: String, timestamp: Instant, eventType: String, event: String): OutboxEvent {
            return OutboxEvent(
                id = id,
                timestamp = timestamp,
                event = eventType,
                eventType = event,
                state = OutboxState.PENDING
            )
        }
    }
}
