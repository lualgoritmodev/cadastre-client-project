plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
}

group = "com.garcia.luciano"
version = "0.0.1-SNAPSHOT"
description = "Projeto de estudos, cadastrar pessoas"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
	maven {
		url = uri("https://company/com/maven2")
	}
	google()
	gradlePluginPortal()
	mavenLocal()
}

dependencies {
	// Spring Boot Starters
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-starter-security")

	// PostgreSQL Driver
	implementation("org.postgresql:postgresql:42.6.0")

	// Jackson para Kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

	// Kafka
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.apache.kafka:kafka-clients")

	// Desenvolvimento
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// Testes
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.mockito:mockito-core:5.3.0")
	testImplementation("org.mockito.kotlin:mockito-kotlin:5.0.0")
//	testImplementation("org.springframework.security:spring-security-test:6.5.0")
	testImplementation("org.testcontainers:junit-jupiter")

	implementation("org.glassfish.jersey.core:jersey-client:3.1.2")
	implementation("org.glassfish.jersey.inject:jersey-hk2:3.1.2")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// OpenAPI
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

	// https://mvnrepository.com/artifact/org.flywaydb/flyway-core
	implementation("org.flywaydb:flyway-core:9.22.3")

	// JJWT - Versão nova e módulos necessários!
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

}
