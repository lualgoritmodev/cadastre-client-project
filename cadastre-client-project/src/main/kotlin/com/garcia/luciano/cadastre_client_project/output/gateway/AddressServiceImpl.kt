package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.repository.AddressRepository
import com.garcia.luciano.cadastre_client_project.service.AddressService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AddressServiceImpl(val addressRepository: AddressRepository): AddressService {

    override fun createAddress(address: Address): Mono<Address> = addressRepository.save(address)
    override fun getAddressById(idAddress: Long): Mono<Address> {
        TODO("Not yet implemented")
    }
    override  fun getAllAddress(): Flux<Address> = addressRepository.findAll()
    override fun updateAddressById(idAddress: Long, address: Address): Mono<Address> {
        TODO("Not yet implemented")
    }

}
