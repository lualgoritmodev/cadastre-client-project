package com.garcia.luciano.cadastre_client_project.input.controller.dto

import com.garcia.luciano.cadastre_client_project.entity.Address
import java.util.*

data class CreateAddress(
    val idAddress: UUID? = null,
    val idClient: UUID?,
    val cep: String,
    val neighborhood: String,
    val road: String,
    val city: String,
    val numberResidence: String?,
    val ddd: String?,
    val uf: String? = null,
    val complement: String? = null,
) {
    fun toEntity(): Address = Address(
            idAddress = this.idAddress,
            cep = this.cep,
            neighborhood = this.neighborhood,
            road = this.road,
            city = this.city,
            numberResidence = this.numberResidence,
            ddd = this.ddd,
            uf = this.uf,
            complement = this.complement
        )

    companion object {
        fun fromEntity(address: Address): CreateAddress {
            return CreateAddress(
                idAddress = address.idAddress,
                idClient = address.person?.idClient,
                cep = address.cep,
                neighborhood = address.neighborhood,
                road = address.road,
                city = address.city,
                numberResidence = address.numberResidence,
                ddd = address.ddd,
                uf = address.uf,
                complement = address.complement
            )
        }
    }
}
