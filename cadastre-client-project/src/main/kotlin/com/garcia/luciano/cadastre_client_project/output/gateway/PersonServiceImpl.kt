package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Person
import com.garcia.luciano.cadastre_client_project.input.controller.dto.CreatePerson
import com.garcia.luciano.cadastre_client_project.output.gateway.dto.UpdatePersonDTO
import com.garcia.luciano.cadastre_client_project.repository.PersonRepository
import com.garcia.luciano.cadastre_client_project.service.PersonService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class PersonServiceImpl(
    private val personRepository: PersonRepository,
    private val getViaCep: TGetViaCepServiceImpl
): PersonService {
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
        .orElseThrow{ RuntimeException("Não existe o $idPerson")}
    override fun getAllPerson(): List<Person> = personRepository.findAll()
    override fun updatePersonById(idPerson: UUID, person: UpdatePersonDTO): Person {
        TODO("Not yet implemented")
    }

//    override fun updatePersonById(idPerson: Long, person: UpdatePersonDTO): Mono<Person> {
//        //TODO
////        val existingPerson = personRepository.findById(idPerson)?: throw
////                RuntimeException("Id $idPerson não encontrado")
////
////        val updatePerson = person.toEntity(existingPerson)
////
////        return personRepository.save(updatePerson)
//    }

}
