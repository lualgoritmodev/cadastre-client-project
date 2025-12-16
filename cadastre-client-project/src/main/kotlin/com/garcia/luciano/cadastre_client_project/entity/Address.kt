package com.garcia.luciano.cadastre_client_project.entity


import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tb_address")
@JsonIgnoreProperties("person")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAddress: UUID? = null,
    val cep: String,
    val neighborhood : String,
    val road: String,
    val city: String,
    val numberResidence: String?=null,
    val DDD: String,
    val UF: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    @JsonIgnore
    val person: Person? = null
) {
    constructor() : this(
        idAddress = null,
        cep = "",
        neighborhood = "",
        road = "",
        city = "",
        numberResidence = null,
        DDD = "",
        UF = null,
        person = null
    )
}
