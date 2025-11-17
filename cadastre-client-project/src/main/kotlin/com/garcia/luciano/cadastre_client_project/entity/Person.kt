package com.garcia.luciano.cadastre_client_project.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
import jakarta.persistence.OneToMany
import jakarta.persistence.CascadeType
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "tb_person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idPerson: UUID? = null,
    val name: String,
    @Column(unique = true, nullable = false)
    val cpf: String,
    val RG: String,
    val dateOfBirth: LocalDate,
    val genere: String,
    val phone: String,
    val cep: String,
    val numberResidence: String,
    @Column(unique = true, nullable = false)
    @field:Email(message = "E-mail inválido")
    @field:NotBlank(message = "E-mail obrigatório")
    val email: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    val registrationDate: LocalDateTime = LocalDateTime.now(),
    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    var addressClient: MutableSet<Address>
)
