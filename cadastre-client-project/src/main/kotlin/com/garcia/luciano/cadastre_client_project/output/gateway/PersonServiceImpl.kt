package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Person
import com.garcia.luciano.cadastre_client_project.input.controller.dto.CreatePerson
import com.garcia.luciano.cadastre_client_project.output.gateway.dto.UpdatePersonDTO
import com.garcia.luciano.cadastre_client_project.repository.PersonRepository
import com.garcia.luciano.cadastre_client_project.security.jwtconfig.UserDetail
import com.garcia.luciano.cadastre_client_project.service.PersonService
import jakarta.transaction.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonServiceImpl(
    private val personRepository: PersonRepository,
    private val getViaCep: TGetViaCepServiceImpl
): UserDetailsService, PersonService {

    override fun loadUserByUsername(email: String?): UserDetails {
        val userDetail = personRepository.findByEmail(email)?:
        throw RuntimeException("O email não foi encontrado $email")
        return UserDetail(userDetail)
    }
    @Transactional
    override fun createPerson(personDTO: CreatePerson): Person {
        val person = personRepository.save(personDTO.toEntity())
        val existingAddress = getViaCep.getAddress(
            personDTO.cep,
            person,
            personDTO.numberResidence)
        person.addressClient.add(existingAddress)

        return person
    }
    override fun getPersonById(idPerson: UUID): Person = personRepository.findById(idPerson)
        .orElseThrow{ RuntimeException("Não existe o person: $idPerson")}
    override fun getAllPerson(): List<Person> = personRepository.findAll()
    override fun updatePersonById(idPerson: UUID, person: UpdatePersonDTO): Person {
        val existingPerson = personRepository.findById(idPerson).orElseThrow {
            RuntimeException("Este person não existe o person: $idPerson")
        }

            val personUpdate = person.toEntity(existingPerson)
        return personRepository.save(personUpdate)
    }

}
