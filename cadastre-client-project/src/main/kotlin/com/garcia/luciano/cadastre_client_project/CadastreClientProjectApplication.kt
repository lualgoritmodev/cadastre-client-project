package com.garcia.luciano.cadastre_client_project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class CadastreClientProjectApplication

fun main(args: Array<String>) {
	runApplication<CadastreClientProjectApplication>(*args)
	println("Funcionou")
}
