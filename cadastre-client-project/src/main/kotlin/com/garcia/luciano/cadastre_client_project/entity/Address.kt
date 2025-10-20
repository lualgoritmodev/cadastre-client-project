package com.garcia.luciano.cadastre_client_project.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import java.util.UUID

@Entity
@Table(name = "tabela_endereco")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAddress: UUID? = null,
    val cep: String,
    val neighborhood: String,
    val road: String,
    val numberResidence: String,
    val UF: Char,
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    val person: Person
)
