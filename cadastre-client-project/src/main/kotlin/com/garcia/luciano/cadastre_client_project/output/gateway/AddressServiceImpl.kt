package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.repository.AddressRepository
import com.garcia.luciano.cadastre_client_project.service.AddressService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AddressServiceImpl(val addressRepository: AddressRepository): AddressService {

    override fun createAddress(address: Address): Address = addressRepository.save(address)

    override fun getAddressById(idAddress: UUID): Address = addressRepository.findById(idAddress).orElseThrow {
            RuntimeException("Id $idAddress do endereço não encontrado")
        }

    override fun getAllAddress(): List<Address> = addressRepository.findAll()

    override fun updateAddressById(idAddress: UUID, address: Address): Address {
        val existingAddress  = addressRepository.findById(idAddress).orElseThrow {
            RuntimeException("Id $idAddress do endereço não encontrado")
        }
        val updateAddress = existingAddress .copy(
            cep = address.cep,
            road = address.road
        )
        return addressRepository.save(updateAddress)
    }
}