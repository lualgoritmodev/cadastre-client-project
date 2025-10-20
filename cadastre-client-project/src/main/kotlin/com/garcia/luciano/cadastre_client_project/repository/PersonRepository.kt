package com.garcia.luciano.cadastre_client_project.repository

import com.garcia.luciano.cadastre_client_project.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PersonRepository: JpaRepository<Person, UUID>