package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Person
import com.garcia.luciano.cadastre_client_project.output.gateway.dto.UpdatePersonDTO
import com.garcia.luciano.cadastre_client_project.repository.PersonRepository
import com.garcia.luciano.cadastre_client_project.service.PersonService
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonServiceImpl(
    val personRepository: PersonRepository,
    val getViaCep: GetViaCepServiceImpl
): PersonService {
    override suspend fun createPerson(person: Person): Person {
        val address = getViaCep.getAddress(person.cep, person, person.numberResidence)

        person.address.add(address)
        return personRepository.save(person)
    }

    override suspend fun getPersonById(idPerson: UUID): Person = personRepository.findById(idPerson)?: throw
            RuntimeException ("Cliente não encontrado")
    override suspend fun getAllPerson(): List<Person> = personRepository.findAll().toList()
    override suspend fun updatePersonById(idPerson: UUID, person: UpdatePersonDTO): Person {
        val existingPerson = personRepository.findById(idPerson)?: throw
                RuntimeException("Id $idPerson não encontrado")

        val updatePerson = person.toEntity(existingPerson)

        return personRepository.save(updatePerson)
    }

}
