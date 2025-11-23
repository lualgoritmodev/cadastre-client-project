package com.garcia.luciano.cadastre_client_project.security.jwtconfig

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val jwtUtil: JWTUtil,
    private val authManager: AuthenticationConfiguration
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors { it.disable() }
            .authorizeHttpRequests {
                it
                    .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**",
                    "/swagger-resources/**",
                    "/webjars/**",
                    "/configuration/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/v1/persons/person")
                    .hasAnyAuthority("ROLE_ADMIN")
                    .requestMatchers(HttpMethod.GET, "/v1/persons/list-person")
                    .hasAnyAuthority("ROLE_ADMIN", "ROLE_PERSON")
                    .anyRequest().authenticated()

            }
            .addFilterBefore(
                JWTLoginFilter(
                    authenticationManager = authenticationManager(authManager),
                    jwtUtil = jwtUtil
                ),
                UsernamePasswordAuthenticationFilter::class.java
            )
            .addFilterAfter(
                jwtAuthenticationFilter(jwtUtil),
                UsernamePasswordAuthenticationFilter::class.java
            )
            .sessionManagement{
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }

        return http.build()
    }

    @Bean
    fun jwtAuthenticationFilter(jwtUtil: JWTUtil): JWTAuthenticationFilter {
        return JWTAuthenticationFilter(jwtUtil)
    }

    @Bean
    fun passwordEncorder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun authenticationManager(
        authManager: AuthenticationConfiguration
    ): AuthenticationManager = authManager.authenticationManager
}
