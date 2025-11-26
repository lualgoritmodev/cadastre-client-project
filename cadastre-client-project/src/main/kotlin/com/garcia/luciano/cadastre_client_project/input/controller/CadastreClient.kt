package com.garcia.luciano.cadastre_client_project.input.controller

import com.garcia.luciano.cadastre_client_project.input.controller.dto.CreatePerson
import com.garcia.luciano.cadastre_client_project.service.PersonService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/persons")
class CadastreClient(
    private val clientService: PersonService
) {
    @Operation(
        summary = "Criar pessoa (APENAS ADMIN)",
        security = [SecurityRequirement(name ="bearerAuth")]
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/person")
    fun createClient(@Valid @RequestBody personDTO: CreatePerson): ResponseEntity<CreatePerson> {
        val person =  clientService.createPerson(personDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(CreatePerson.fromEntity(person))

    }
    @GetMapping("/list-person")
    fun getAllPerson(): ResponseEntity<List<CreatePerson>> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(clientService.getAllPerson().map { CreatePerson.fromEntity(it) })
    }
    @GetMapping("/{idPerson}")
    fun getPersonById(idPerson: UUID): ResponseEntity<CreatePerson> {
        val person = clientService.getPersonById(idPerson)
        return ResponseEntity.status(HttpStatus.OK).body(CreatePerson.fromEntity(person))
    }

}
