package com.garcia.luciano.cadastre_client_project.service

import com.garcia.luciano.cadastre_client_project.service.dtoservice.AddressResponseDTO

interface GetViaCepService {
    suspend fun getViaCep(cep: String): AddressResponseDTO
}