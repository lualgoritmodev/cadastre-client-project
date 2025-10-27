plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
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
	google()
	gradlePluginPortal()
}

dependencies {
	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// Testes
	testImplementation("org.jetbrains.kotlin:kotlin-test")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// Serialização JSON
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

	// Ktor Client Core
	implementation("io.ktor:ktor-client-core:2.3.7")
	implementation("io.ktor:ktor-client-cio:2.3.7")
	implementation("io.ktor:ktor-client-content-negotiation:2.3.7")
	implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")

	// Coroutines
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

	implementation("org.springframework.boot:spring-boot-starter-validation")

	//Jakarta
	implementation("jakarta.ws.rs:jakarta.ws.rs-api:3.1.0")

	//Jackson para o Clint
	implementation("io.ktor:ktor-serialization-jackson:2.3.4")

	//PostGreSQL
	implementation("org.postgresql:postgresql:42.7.2")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE")

	implementation("org.springframework.boot:spring-boot-starter-webflux") // Inclui o WebClient
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")     // Para usar coroutines com WebFlux

	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
