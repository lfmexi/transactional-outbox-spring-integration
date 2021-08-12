package org.lfmexi.transactional.outbox.sample.event.account

import com.fasterxml.jackson.databind.ObjectMapper
import org.lfmexi.transactional.outbox.sample.domain.AccountEvent
import org.lfmexi.transactional.outbox.sample.domain.DomainEvent
import org.lfmexi.transactional.outbox.sample.event.outbox.OutboxEvent
import org.springframework.stereotype.Component

@Component
internal class DomainEventMapper(
    private val objectMapper: ObjectMapper
) {
    fun createOutboxMessageFromEvent(domainEvent: DomainEvent): OutboxEvent {
        return when (domainEvent) {
            is AccountEvent -> AccountEventMessage.from(domainEvent)
                .let {
                    OutboxEvent.create(
                        id = it.eventId,
                        eventType = it.eventType.name,
                        timestamp = it.eventTimestamp,
                        event = objectMapper.writeValueAsString(it)
                    )
                }
            else -> throw RuntimeException()
        }
    }
}
