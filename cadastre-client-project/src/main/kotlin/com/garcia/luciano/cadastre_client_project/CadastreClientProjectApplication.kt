package com.garcia.luciano.cadastre_client_project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("com.garcia.luciano.cadastre_client_project.entity")
class CadastreClientProjectApplication
fun main(args: Array<String>) {
	runApplication<CadastreClientProjectApplication>(*args)
}
