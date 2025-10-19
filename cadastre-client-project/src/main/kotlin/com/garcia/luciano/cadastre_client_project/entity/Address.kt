package com.garcia.luciano.cadastre_client_project.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tabela_endereco")
data class Address(
    @Id
    val idAddress: Long,
    val cep: String,
    val neighborhood: String,
    val road: String,
    val numberResidence: String
)
