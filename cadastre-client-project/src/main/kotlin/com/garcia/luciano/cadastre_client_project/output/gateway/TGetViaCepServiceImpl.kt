package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.entity.Person
import com.garcia.luciano.cadastre_client_project.service.GetViaCepService
import com.garcia.luciano.cadastre_client_project.service.dtoservice.AddressResponseDTO
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.reactive.function.client.WebClient

class TGetViaCepServiceImpl(
    private val webClient: WebClient
): GetViaCepService {

    @Value("\${viacep.url}")
    lateinit var  viaCepUrl: String

    override suspend fun getViaCep(cep: String): AddressResponseDTO {
        val uri = "$viaCepUrl/$cep/json"

        return webClient.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(AddressResponseDTO::class.java)
            .awaitSingle()
    }

    suspend fun getAddress(
        cep: String,
        person: Person,
        numberResidence: String
    ): Address {
        val addressResponse = this.getViaCep(cep)
        if (addressResponse.cep.isNullOrEmpty() || numberResidence.isNullOrEmpty()) {
            throw IllegalArgumentException("Dados inválidos")
        }
        return Address(
            cep = addressResponse.cep,
            neighborhood = addressResponse.bairro ?: "Preencha o Bairro",
            road = addressResponse.logradouro ?: "Preencha a rua",
            city = addressResponse.localidade ?: "Preencha a cidade",
            DDD = addressResponse.ddd ?: "Preencha a cidade",
            numberResidence = addressResponse.numberResidence,
        )
    }
}