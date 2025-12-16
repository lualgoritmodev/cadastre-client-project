package com.garcia.luciano.cadastre_client_project.input.controller

import com.garcia.luciano.cadastre_client_project.service.AddressService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/address")
class CadastreAddress(
    private val addressService: AddressService
) {

//    @PostMapping("/create-address")
//    fun createAddress(idClient: UUID,
//                      @Valid @RequestBody address: CreateAddress): ResponseEntity<CreateAddress> {
//
//    }
}