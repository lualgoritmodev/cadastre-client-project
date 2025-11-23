package com.garcia.luciano.cadastre_client_project.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority
import java.util.*

data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID?= null,
    val name: String
): GrantedAuthority {
    override fun getAuthority(): String = name

}
