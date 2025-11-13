package com.garcia.luciano.cadastre_client_project.input.controller.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.garcia.luciano.cadastre_client_project.entity.Person
import java.time.LocalDate
import java.time.LocalDateTime

data class CreatePerson(
    val idPerson: Long?= null,
    val name: String,
    val cpf: String,
    val cep: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val dateOfBirth: LocalDate,
    val numberResidence: String? = null,
    val phone: String,
    val genere: String,
    val email: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    val registrationDate: LocalDateTime = LocalDateTime.now(),
    val addressClient: MutableSet<CreateAddressDTO> = mutableSetOf()
) {
    fun toEntity() = Person(
        idPerson = this.idPerson,
        name = this.name,
        dateOfBirth = this.dateOfBirth,
        genere = this.genere,
        cpf = this.cpf,
        cep = this.cep,
        phone = this.phone,
        numberResidence = this.numberResidence?:"Não tem número?",
        email = this.email,
        registrationDate = this.registrationDate
    )

    companion object {
        fun fromEntity(person: Person) = CreatePerson(
            name = person.name,
            cpf = person.cpf,
            cep = person.cep,
            numberResidence = person.numberResidence,
            dateOfBirth = person.dateOfBirth,
            phone = person.phone,
            genere = person.genere,
            email = person.email,
        )
    }

}

data class CreateAddressDTO(val cep: String, val numberResidence: String? = null)
