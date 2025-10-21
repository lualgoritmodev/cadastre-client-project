package com.garcia.luciano.cadastre_client_project.output.gateway

import com.garcia.luciano.cadastre_client_project.entity.Person
import com.garcia.luciano.cadastre_client_project.output.gateway.dto.UpdatePersonDTO
import com.garcia.luciano.cadastre_client_project.repository.PersonRepository
import com.garcia.luciano.cadastre_client_project.service.PersonService
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonServiceImpl(
    val personRepository: PersonRepository
): PersonService {
    override fun createPerson(person: Person): Person = personRepository.save(person)

    override fun getPersonById(idPerson: UUID): Person = personRepository.findById(idPerson).orElseThrow {
            RuntimeException ("Cliente não encontrado")
        }

    override fun getAllPerson(): List<Person> = personRepository.findAll()

    override fun updatePersonById(idPerson: UUID, person: UpdatePersonDTO): Person {
        val existingPerson = personRepository.findById(idPerson)
            .orElseThrow {
                RuntimeException("Id $idPerson não encontrado")
            }
        val updatePerson = person.toEntity(existingPerson)

        return personRepository.save(updatePerson)
    }
}
