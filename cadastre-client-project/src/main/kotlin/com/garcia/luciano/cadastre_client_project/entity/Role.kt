package com.garcia.luciano.cadastre_client_project.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority
import java.util.*

data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_role")
    val idRole: UUID?= null,
    @JsonProperty("role_name")
    val name: String
): GrantedAuthority {
    override fun getAuthority(): String = name

}
