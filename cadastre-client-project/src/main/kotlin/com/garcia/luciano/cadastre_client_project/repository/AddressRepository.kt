package com.garcia.luciano.cadastre_client_project.repository

import com.garcia.luciano.cadastre_client_project.entity.Address
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AddressRepository: CoroutineCrudRepository<Address, UUID>