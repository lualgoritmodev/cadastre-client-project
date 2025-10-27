package com.garcia.luciano.cadastre_client_project.service

import com.garcia.luciano.cadastre_client_project.entity.Person
import com.garcia.luciano.cadastre_client_project.output.gateway.dto.UpdatePersonDTO
import java.util.UUID

interface PersonService {
    suspend fun createPerson(person: Person): Person
    suspend fun getPersonById(idPerson: UUID): Person
    suspend fun getAllPerson(): List<Person>
    suspend fun updatePersonById(idPerson: UUID, person: UpdatePersonDTO): Person
}