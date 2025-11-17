//package com.garcia.luciano.cadastre_client_project.profile
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Profile
//import org.springframework.web.reactive.function.client.WebClient
//
//@Configuration
//class ConfigProfile {
//
//    @Bean
//    @Profile("dev")
//    fun devClient(): WebClient = WebClient.builder()
//        .baseUrl("teste-dev")
//        .build()
//
//    @Bean
//    @Profile("hom")
//    fun homClient(): WebClient = WebClient.builder()
//        .baseUrl("teste-hom")
//        .build()
//}