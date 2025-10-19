package com.garcia.luciano.cadastre_client_project.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tabela_pessoa")
data class Person(
    @Id
    val idPerson: Int,
    val name: String,
    val age: Int?,
    val genere: String,
    val cep: String,
    val address: MutableSet<Address> = mutableSetOf()
)
