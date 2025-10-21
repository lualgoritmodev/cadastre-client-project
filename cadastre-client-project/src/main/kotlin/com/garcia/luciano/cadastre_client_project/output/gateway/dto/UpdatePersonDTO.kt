package com.garcia.luciano.cadastre_client_project.output.gateway.dto

import com.garcia.luciano.cadastre_client_project.entity.Person
import jakarta.persistence.Column
import jakarta.validation.constraints.Email

data class UpdatePersonDTO(
    val cep: String,
    val phone: String,
    @Email
    @Column(unique = true, nullable = false)
    val email: String
) {
    fun toEntity(existingPerson: Person) = existingPerson.copy(
        cep = this.cep,
        phone = this.phone,
        email = this.email
    )

    companion object {
        fun fronEntity(person: Person) = UpdatePersonDTO(
            cep = person.cep,
            phone = person.phone,
            email = person.email
        )
    }
}