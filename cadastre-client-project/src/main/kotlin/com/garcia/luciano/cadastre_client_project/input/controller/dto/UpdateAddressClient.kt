package com.garcia.luciano.cadastre_client_project.input.controller.dto

import com.garcia.luciano.cadastre_client_project.entity.Address

data class UpdateAddressClient(
    val numberResidence: String,
    val complement: String,
    val road: String
) {
    fun toEntity(existingAddress: Address): Address = existingAddress.copy(
        numberResidence = this.numberResidence,
        complement = this.complement,
        road = this.road
    )

    companion object {
        fun fromEntity(address: Address): UpdateAddressClient? =
            address.complement?.let { complement ->
                address.numberResidence?.let { numberResidence ->
                    address.road?.let { road ->
                        UpdateAddressClient(numberResidence = numberResidence, complement = complement, road = road)
                    }
                }
            }
    }

}
