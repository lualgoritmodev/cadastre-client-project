package com.garcia.luciano.cadastre_client_project.service

import com.garcia.luciano.cadastre_client_project.entity.Address

interface AddressService {
    fun createAddress(address: Address): Address
    fun getAddressById(idAddress:Long): Address
    fun getAllAddress(): List<Address>
    fun updateAddressById(idAddress: Long, address: Address): Address
}