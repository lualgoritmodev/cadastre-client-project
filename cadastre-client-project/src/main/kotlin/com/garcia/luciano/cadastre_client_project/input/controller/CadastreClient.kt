package com.garcia.luciano.cadastre_client_project.input.controller

import com.garcia.luciano.cadastre_client_project.input.controller.dto.CreatePerson
import com.garcia.luciano.cadastre_client_project.service.PersonService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/create-persons")
class CadastreClient(
    private val clientService: PersonService
) {
    @PostMapping("/person")
    suspend fun createClient(@Valid @RequestBody personDTO: CreatePerson): Mono<ResponseEntity<CreatePerson>> {
        return clientService.createPerson(personDTO)
            .map {
                ResponseEntity.status(HttpStatus.CREATED).body(CreatePerson.fromEntity(it))
            }
    }

}
