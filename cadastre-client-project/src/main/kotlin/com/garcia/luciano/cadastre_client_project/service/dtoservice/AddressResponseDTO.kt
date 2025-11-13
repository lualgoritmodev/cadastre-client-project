package com.garcia.luciano.cadastre_client_project.service.dtoservice

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.entity.Person

data class AddressResponseDTO(
    val cep: String,
    val logradouro: String? = null,
    val bairro: String? = null,
    val localidade: String? = null,
    val uf: String? = null,
    val numberResidence: String?=null,
    val ddd: String? = null
) {
    fun toEntity(person: Person) = Address(
        cep = this.cep,
        neighborhood = this.bairro?: "",
        road = this.logradouro ?: "",
        city = this.localidade ?: "",
        numberResidence = person.numberResidence?:"",
        DDD = this.ddd ?:"",
        UF = this.uf ?: "",
    )
}
