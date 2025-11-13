package com.garcia.luciano.cadastre_client_project.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.UUID
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "tb_person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val idPerson: UUID? = null,
    val name: String,
    @Column(unique = true, nullable = false)
    val cpf: String,
    val RG: String,
    val dateOfBirth: LocalDate,
    val genere: String,
    val phone: String,
    val cep: String,
    val numberResidence: String,
    @Column(unique = true, nullable = false)
    @field:Email(message = "E-mail inválido")
    @field:NotBlank(message = "E-mail obrigatório")
    val email: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    val registrationDate: LocalDateTime = LocalDateTime.now(),
    @OneToMany(mappedBy = "personId", cascade = [CascadeType.ALL], orphanRemoval = true)
    var addressClient: MutableSet<Address>
) {
    constructor() : this(
        idPerson = null,
        name = "",
        cpf= "",
        RG= "",
        dateOfBirth = LocalDate.now(),
        genere = "",
        phone = "",
        cep = "",
        numberResidence = "",
        email = "",
        registrationDate = LocalDateTime.now(),
        addressClient = mutableSetOf()
    )
}
