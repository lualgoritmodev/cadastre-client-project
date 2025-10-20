package com.garcia.luciano.cadastre_client_project.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.util.UUID

@Entity
@Table(name = "tabela_documentos")
data class Document(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idDocument: UUID? = null,
    val cpf:String,
    val rg: String,
    val cardMotorist: String? = null,
)