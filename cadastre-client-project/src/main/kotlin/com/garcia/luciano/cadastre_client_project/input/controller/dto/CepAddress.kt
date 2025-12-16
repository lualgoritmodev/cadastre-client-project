package com.garcia.luciano.cadastre_client_project.input.controller.dto

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.entity.Person
import java.util.UUID

data class CepAddress(
    val idAddress: UUID?,
    val cep: String,
    val numberResidence: String?,
    val person: Person?
) {
    companion object {
        fun fromEntity(address: Address) = CepAddress(
            idAddress = address.idAddress,
            cep = address.cep,
            numberResidence = address.numberResidence,
            person = address.person
        )
    }
}
