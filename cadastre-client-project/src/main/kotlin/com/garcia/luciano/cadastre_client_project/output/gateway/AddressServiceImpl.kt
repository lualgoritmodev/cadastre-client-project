package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.repository.AddressRepository
import com.garcia.luciano.cadastre_client_project.service.AddressService
import jakarta.transaction.Transactional
import org.hibernate.validator.constraints.UUID
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl(val addressRepository: AddressRepository): AddressService {

    override fun createAddress(address: Address): Address = addressRepository.save(address)
    @Transactional
    override fun getAddressById(idAddress: UUID): Address = addressRepository.findById(idAddress).orElseThrow {
           RuntimeException("Não existe o address: $idAddress")
       }

    override  fun getAllAddress(): List<Address> = addressRepository.findAll()
    @Transactional
    override fun updateAddressById(idAddress: UUID, address: Address): Address {
        val existingAddress = addressRepository.findById(idAddress)
            .orElseThrow { RuntimeException("Não existe o address: $idAddress") }

        val updateAddress = existingAddress.copy(
            numberResidence = address.numberResidence
        )
        return addressRepository.save(updateAddress)
    }

}
