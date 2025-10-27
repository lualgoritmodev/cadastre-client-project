package com.garcia.luciano.cadastre_client_project.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.util.UUID

@Table(name = "tb_person")
data class Person(
    @Id
    val idPerson: UUID? = null,
    val name: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    val dateOfBirth: LocalDate,
    val genere: String,
    val phone: String,
    val cep: String,
    val numberResidence: String,
    @field:Email(message = "E-mail inválido")
    @field:NotBlank(message = "E-mail obrigatório")
    val email: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    val registrationDate: LocalDate,
    val address: MutableSet<Address> = mutableSetOf()
)
