package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.repository.AddressRepository
import com.garcia.luciano.cadastre_client_project.service.AddressService
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AddressServiceImpl(val addressRepository: AddressRepository): AddressService {

    override suspend fun createAddress(address: Address): Address = addressRepository.save(address)
    override suspend fun getAddressById(idAddress: UUID): Address = addressRepository.findById(idAddress)?: throw
            RuntimeException("Id $idAddress do endereço não encontrado")

    override suspend fun getAllAddress(): List<Address> = addressRepository.findAll().toList()

    override suspend fun updateAddressById(idAddress: UUID, address: Address): Address {
        val existingAddress  = addressRepository.findById(idAddress)?: throw
            RuntimeException("Id $idAddress do endereço não encontrado")

        val updateAddress = existingAddress .copy(
            cep = address.cep,
            road = address.road
        )
        return addressRepository.save(updateAddress)
    }
}