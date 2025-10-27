package com.garcia.luciano.cadastre_client_project.output.gateway.dto

import com.garcia.luciano.cadastre_client_project.entity.Person
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UpdatePersonDTO(
    val cep: String,
    val phone: String,
    @field:Email(message = "E-mail inválido")
    @field:NotBlank(message = "Não pode ser vazio")
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