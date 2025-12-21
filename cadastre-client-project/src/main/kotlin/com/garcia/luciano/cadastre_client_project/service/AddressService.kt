package com.garcia.luciano.cadastre_client_project.service

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.input.controller.dto.CepAddress
import java.util.*

interface AddressService {
    fun createAddress(idPerson: UUID, cepAddress: CepAddress): Address
    fun getAddressById(idAddress:UUID): Address
    fun getAllAddress(): List<Address>
    fun updateAddressById(idAddress: UUID, address: Address): Address
    fun updateAddressByIdPerson(idPerson: UUID, idAddress: UUID, address: Address): Address
}