package com.garcia.luciano.cadastre_client_project.service

import com.garcia.luciano.cadastre_client_project.entity.Address
import java.util.UUID

interface AddressService {
    suspend fun createAddress(address: Address): Address
    suspend fun getAddressById(idAddress:UUID): Address
    suspend fun getAllAddress(): List<Address>
    suspend fun updateAddressById(idAddress: UUID, address: Address): Address
}