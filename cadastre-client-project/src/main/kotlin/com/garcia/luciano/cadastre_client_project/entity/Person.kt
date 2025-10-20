package com.garcia.luciano.cadastre_client_project.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "tabela_pessoa")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idPerson: UUID? = null,
    val name: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    val dateOfBirth: LocalDate,
    val genere: String,
    val cep: String,
    @Email
    @Column(unique = true, nullable = false)
    val email: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    val registrationDate: LocalDate,
    @OneToOne()
    @Column(unique = true, nullable = false)
    @JoinColumn(name = "documentos")
    val document: Document,
    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    val address: MutableSet<Address> = mutableSetOf()
)
