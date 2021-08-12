package org.lfmexi.transactional.outbox.sample.event.outbox.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.InboundChannelAdapter
import org.springframework.integration.annotation.Poller
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.config.EnableIntegration
import org.springframework.integration.core.MessageSource
import org.springframework.messaging.MessageChannel
import javax.sql.DataSource
import javax.sql.rowset.JdbcRowSet

@Configuration
@EnableIntegration
internal class RelayConfiguration {
    @Bean
    fun relayChannel(): MessageChannel {
        return DirectChannel()
    }
}
