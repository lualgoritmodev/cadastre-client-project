package com.garcia.luciano.cadastre_client_project.input.controller.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.entity.Person
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class CreatePerson(
    val idPerson: UUID?= null,
    val name: String,
    val cpf: String,
    val RG: String,
    val cep: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val dateOfBirth: LocalDate,
    val numberResidence: String? = null,
    val phone: String,
    val genere: String,
    val email: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    val registrationDate: LocalDateTime = LocalDateTime.now(),
    val addressClient: MutableSet<Address> = mutableSetOf()
) {
    fun toEntity() = Person(
        name = this.name,
        cpf = this.cpf,
        RG = this.RG,
        dateOfBirth = this.dateOfBirth,
        genere = this.genere,
        cep = this.cep,
        phone = this.phone,
        numberResidence = this.numberResidence ?: "Não tem número?",
        email = this.email,
        registrationDate = this.registrationDate,
        addressClient = this.addressClient
    )

    companion object {
        fun fromEntity(person: Person) = CreatePerson(
            name = person.name,
            cpf = person.cpf,
            RG = person.RG,
            dateOfBirth = person.dateOfBirth,
            genere = person.genere,
            cep = person.cep,
            phone = person.phone,
            numberResidence = person.numberResidence,
            email = person.email,
            registrationDate = person.registrationDate,
            addressClient = mutableSetOf()
        )
    }

}
data class CreateAddressDTO(val cep: String, val numberResidence: String? = null)
