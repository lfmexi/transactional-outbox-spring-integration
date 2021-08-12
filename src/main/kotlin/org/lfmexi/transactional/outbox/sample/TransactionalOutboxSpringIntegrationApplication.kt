package org.lfmexi.transactional.outbox.sample

import org.lfmexi.transactional.outbox.sample.event.outbox.configuration.TransactionalOutboxConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(TransactionalOutboxConfiguration::class)
@SpringBootApplication
class TransactionalOutboxSpringIntegrationApplication

fun main(args: Array<String>) {
	runApplication<TransactionalOutboxSpringIntegrationApplication>(*args)
}
