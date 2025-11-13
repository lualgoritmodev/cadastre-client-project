package com.garcia.luciano.cadastre_client_project.output.gateway

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.garcia.luciano.cadastre_client_project.entity.Address
import com.garcia.luciano.cadastre_client_project.entity.Person
import com.garcia.luciano.cadastre_client_project.service.GetViaCepService
import com.garcia.luciano.cadastre_client_project.service.dtoservice.AddressResponseDTO
import jakarta.ws.rs.ProcessingException
import jakarta.ws.rs.client.Client
import jakarta.ws.rs.client.WebTarget
import jakarta.ws.rs.core.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class TGetViaCepServiceImpl(
    @Autowired private val builder: Client,
    @Autowired private val objectMapper: ObjectMapper
): GetViaCepService {

    @Value("\${viacep.url}")
    lateinit var  viaCepUrl: String
    override fun getViaCep(cep: String): AddressResponseDTO {
        val uri = "$viaCepUrl/$cep/json"
        return try {
            val webTarget: WebTarget = builder.target("$viaCepUrl$cep/json/")
            val responseJson = webTarget.request(MediaType.APPLICATION_JSON).get(String::class.java)
            objectMapper.readValue(responseJson, AddressResponseDTO::class.java)
        } catch (e: ProcessingException) {
            throw IllegalArgumentException("Erro de comunicação ao consultar o CEP $cep: ${e.message}", e)
        } catch (e: JsonProcessingException) {
            throw IllegalArgumentException("Erro ao processar a resposta do CEP $cep: ${e.message}", e)
        }
    }
    fun getAddress(cep: String, person: Person? = null, numberResidence: String?=null): Address {
        val addressResponse = this.getViaCep(cep)
        if (addressResponse.cep.isNullOrEmpty() || addressResponse.logradouro.isNullOrEmpty()) {
            throw IllegalArgumentException("Dados de endereço inválidos retornados para o CEP $cep")
        }
        return Address(
            cep = addressResponse.cep,
            neighborhood = addressResponse.bairro ?: "Bairro não informado",
            road = addressResponse.logradouro ?: "Rua não informada",
            city = addressResponse.localidade ?: "Cidade não informada",
            numberResidence = numberResidence,
            DDD = "", // Preencha conforme necessário
            UF = addressResponse.uf ?: "UF não informada",
            person = person?.idPerson
        )
    }
}
