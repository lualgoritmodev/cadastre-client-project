package com.garcia.luciano.cadastre_client_project.security

import com.garcia.luciano.cadastre_client_project.output.gateway.PersonServiceImpl
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component
import java.util.Date
import javax.crypto.SecretKey

@Component
class JWTUtil(private val person: PersonServiceImpl) {

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    private val expiration = 120000

    fun generateToken(userName: String, authorities: MutableCollection<out GrantedAuthority>): String? {
        val key: SecretKey = Keys.hmacShaKeyFor(secret.toByteArray())

        return Jwts.builder()
            .setSubject(userName)
            .claim("role", authorities.map { it.authority })
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact()
    }

    fun isValid(token: String?): Boolean {
        if(token.isNullOrBlank()) return false
        return try {
            Jwts.parserBuilder()
                .setSigningKey(secret.toByteArray())
                .build()
                .parseClaimsJws(token)
            true
        } catch(e: Exception) {
            false
        }
    }

    fun getAuthentication(jwt: String?): Authentication {
        val userName = Jwts.parserBuilder()
            .setSigningKey(secret.toByteArray())
            .build().parseClaimsJws(jwt)
            .body.subject

        val user = person.loadUserByUsername(userName)
        return UsernamePasswordAuthenticationToken(userName, null, user.authorities)
    }

}
