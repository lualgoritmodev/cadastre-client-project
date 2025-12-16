package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.input.controller.dto.CepAddress
import com.garcia.luciano.cadastre_client_project.repository.AddressRepository
import com.garcia.luciano.cadastre_client_project.service.AddressService
import com.garcia.luciano.cadastre_client_project.service.PersonService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddressServiceImpl(
    val addressRepository: AddressRepository,
    val personService: PersonService,
    val viaCepServiceImpl: TGetViaCepServiceImpl): AddressService {

    override fun createAddress(idPerson: UUID, cepAddress: CepAddress, address: Address): Address {
        val person = idPerson?.let { personService.getPersonById(it) }
        val newAddress = viaCepServiceImpl.getAddress(cepAddress.cep, person, cepAddress.numberResidence)

        person?.addressClient?.let { address ->
           if(address.any { it.cep == newAddress.cep }) {
               throw RuntimeException("Este endereço já existe: $cepAddress")
           }
        }

        val savedAddress = addressRepository.save(newAddress)
        person!!.addressClient.add(savedAddress)

        return savedAddress
    }
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
