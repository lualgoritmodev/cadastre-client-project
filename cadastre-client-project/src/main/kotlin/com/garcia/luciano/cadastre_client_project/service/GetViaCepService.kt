package com.garcia.luciano.cadastre_client_project.service

import com.garcia.luciano.cadastre_client_project.service.dtoservice.AddressResponseDTO
import reactor.core.publisher.Mono

interface GetViaCepService {
     fun getViaCep(cep: String): Mono<AddressResponseDTO>
}