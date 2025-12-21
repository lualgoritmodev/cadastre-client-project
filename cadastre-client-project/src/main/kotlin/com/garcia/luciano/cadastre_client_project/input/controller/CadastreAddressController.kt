package com.garcia.luciano.cadastre_client_project.input.controller

import com.garcia.luciano.cadastre_client_project.input.controller.dto.CepAddress
import com.garcia.luciano.cadastre_client_project.input.controller.dto.CreateAddress
import com.garcia.luciano.cadastre_client_project.input.controller.dto.UpdateAddressClient
import com.garcia.luciano.cadastre_client_project.service.AddressService
import com.garcia.luciano.cadastre_client_project.service.PersonService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/address")
class CadastreAddressController(
    private val addressService: AddressService
) {
    @PostMapping("/create-address")
    fun createAddress(@PathVariable("{idPerson}") idPerson: UUID,
                      @Valid @RequestBody cepAddress: CepAddress): ResponseEntity<CreateAddress> {
        val address = addressService.createAddress(idPerson = idPerson, cepAddress = cepAddress)
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateAddress.fromEntity(address))
    }
    @GetMapping("/addressAll")
    fun getAllAddress(): List<ResponseEntity<CreateAddress>> {
        return addressService.getAllAddress().map {
            ResponseEntity.status(HttpStatus.OK).body(CreateAddress.fromEntity(it))
        }
    }
    @GetMapping("/address-id")
    fun getByIdAddress(
        @PathVariable("{idAddress") idAddress: UUID,
    ): ResponseEntity<CreateAddress> {
        val address =  addressService.getAddressById(idAddress = idAddress)
        return ResponseEntity.status(HttpStatus.OK).body(CreateAddress.fromEntity(address))
    }
    @PutMapping("/update-address")
    fun updateAddressById(
        @PathVariable("{idAddress}") idAddress: UUID,
        @Valid @RequestBody updateAddress: CreateAddress
    ): ResponseEntity<CreateAddress> {
        val updateAddress = addressService.updateAddressById(
            idAddress, updateAddress.toEntity()
        )

        return ResponseEntity.status(HttpStatus.OK).body(CreateAddress.fromEntity(updateAddress))
    }
    @PutMapping("/update-address")
    fun updateAddressByIdPerson(
        @PathVariable("{idAddress}") idAddress: UUID,
        @PathVariable("{idPerson}") idPerson: UUID,
        @Valid @RequestBody updateAddress: UpdateAddressClient
    ): ResponseEntity<UpdateAddressClient> {
       val existingAddress = addressService.getAddressById(idAddress)

        val updateAddress = updateAddress.toEntity(existingAddress)

        val savedAddress = addressService.updateAddressByIdPerson(
            idPerson = idPerson,
            idAddress = idAddress,
            address = updateAddress
        )
        return ResponseEntity.status(HttpStatus.OK).body(UpdateAddressClient.fromEntity(savedAddress))
    }

}
