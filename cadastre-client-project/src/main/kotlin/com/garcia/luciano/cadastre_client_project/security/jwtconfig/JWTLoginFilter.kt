package com.garcia.luciano.cadastre_client_project.security.jwtconfig

import com.fasterxml.jackson.databind.ObjectMapper
import com.garcia.luciano.cadastre_client_project.security.model.Credentials
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class JWTLoginFilter(
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JWTUtil
): UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?): Authentication {
        val (userName, password) =
            ObjectMapper().readValue(request?.inputStream, Credentials::class.java)
        val token = UsernamePasswordAuthenticationToken(userName, password)
        return authenticationManager.authenticate(token)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        val user = (authResult?.principal as UserDetail)
        val token = jwtUtil.generateToken(user.username, user.authorities)
        response?.addHeader("Authorization", "Bearer $token")
    }

}
