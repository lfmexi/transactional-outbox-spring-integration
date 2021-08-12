package org.lfmexi.transactional.outbox.sample.event.outbox

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity(name = "outbox_event")
internal data class OutboxEventEntity(
    @Id
    val id: String,

    val timestamp: Instant,

    val eventType: String,

    @Enumerated(EnumType.STRING)
    val state: OutboxState,

    val event: String
) {
    companion object {
        fun from(outboxEvent: OutboxEvent): OutboxEventEntity {
            return with(outboxEvent) {
                OutboxEventEntity(
                    id = id,
                    timestamp = timestamp,
                    eventType = eventType,
                    state = state,
                    event = event
                )
            }
        }
    }
}
