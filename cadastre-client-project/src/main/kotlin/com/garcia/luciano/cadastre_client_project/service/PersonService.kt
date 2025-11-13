package com.garcia.luciano.cadastre_client_project.service

import com.garcia.luciano.cadastre_client_project.entity.Person
import com.garcia.luciano.cadastre_client_project.input.controller.dto.CreatePerson
import com.garcia.luciano.cadastre_client_project.output.gateway.dto.UpdatePersonDTO
import java.util.UUID

interface PersonService {
     fun createPerson(person: CreatePerson): Person
     fun getPersonById(idPerson: UUID): Person
     fun getAllPerson(): List<Person>
     fun updatePersonById(idPerson: UUID, person: UpdatePersonDTO): Person
}