package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.repository.AddressRepository
import com.garcia.luciano.cadastre_client_project.service.AddressService
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl(val addressRepository: AddressRepository): AddressService {

    override fun createAddress(address: Address): Address = addressRepository.save(address)
    override fun getAddressById(idAddress: Long): Address {
        TODO("Not yet implemented")
    }
    override  fun getAllAddress(): List<Address> = addressRepository.findAll()
    override fun updateAddressById(idAddress: Long, address: Address): Address {
        TODO("Not yet implemented")
    }

}
