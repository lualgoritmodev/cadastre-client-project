package com.garcia.luciano.cadastre_client_project.repository

import com.garcia.luciano.cadastre_client_project.entity.Address
import org.hibernate.validator.constraints.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface AddressRepository: JpaRepository<Address, UUID>