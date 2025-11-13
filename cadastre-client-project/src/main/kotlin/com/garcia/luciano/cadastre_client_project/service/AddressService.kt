package com.garcia.luciano.cadastre_client_project.service

import com.garcia.luciano.cadastre_client_project.entity.Address
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AddressService {
    fun createAddress(address: Address): Mono<Address>
    fun getAddressById(idAddress:Long): Mono<Address>
    fun getAllAddress(): Flux<Address>
    fun updateAddressById(idAddress: Long, address: Address): Mono<Address>
}