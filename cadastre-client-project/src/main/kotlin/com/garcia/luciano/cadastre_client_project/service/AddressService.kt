package com.garcia.luciano.cadastre_client_project.service

import com.garcia.luciano.cadastre_client_project.entity.Address
import java.util.UUID

interface AddressService {
    fun createAddress(address: Address): Address
    fun getAddressById(idAddress:UUID): Address
    fun getAllAddress(): List<Address>
    fun updateAddressById(idAddress: UUID, address: Address): Address
}