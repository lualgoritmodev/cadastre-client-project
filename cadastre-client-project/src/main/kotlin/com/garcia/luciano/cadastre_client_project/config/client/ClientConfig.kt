package com.garcia.luciano.cadastre_client_project.config.client

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class ClientConfig {
    @Bean
    fun client():WebClient = WebClient.builder().build()
}