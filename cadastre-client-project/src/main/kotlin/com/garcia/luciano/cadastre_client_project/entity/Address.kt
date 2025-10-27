package com.garcia.luciano.cadastre_client_project.entity

import jakarta.validation.constraints.NotBlank
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table(name = "tb_address")
data class Address(
    @Id
    val idAddress: UUID? = null,
    @field:NotBlank(message = "CEP obrigatório")
    val cep: String,
    @field:NotBlank(message = "Rua e obrigatório")
    val neighborhood: String,
    @field:NotBlank(message = "Rua é obrigatório")
    val road: String,
    @field:NotBlank(message = "Cidade é obrigatório")
    val city: String,
    @field:NotBlank(message = "Não tem número sua casa?")
    val numberResidence: String,
    val DDD: String,
    val UF: String? = null,
    val personId: UUID ? = null
)
