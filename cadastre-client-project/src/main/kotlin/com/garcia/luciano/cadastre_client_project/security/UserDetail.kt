package com.garcia.luciano.cadastre_client_project.security

import com.garcia.luciano.cadastre_client_project.entity.Person
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(private val person: Person): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        person.role.map { SimpleGrantedAuthority(it.name) }.toMutableList()

    override fun getPassword(): String {
        TODO("Not yet implemented")

    }

    override fun getUsername(): String {
        TODO("Not yet implemented")
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }
}