package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.entity.Person
import com.garcia.luciano.cadastre_client_project.service.GetViaCepService
import com.garcia.luciano.cadastre_client_project.service.dtoservice.AddressResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.jackson.jackson
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class GetViaCepServiceImpl: GetViaCepService {

    @Value("\${viacep.url}")
    lateinit var viaCepUrl: String

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) { jackson() }
    }

    override suspend fun getViaCep(cep: String): AddressResponseDTO {
        val url = "$viaCepUrl/$cep/json"
        return client.get(url).body()
    }

     suspend fun getAddress(
        cep: String,
        person: Person,
        numberResidence: String): Address {

         val addressResponse = this.getViaCep(cep)
         if(addressResponse.cep.isNullOrEmpty() || numberResidence.isNullOrEmpty()) {
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
