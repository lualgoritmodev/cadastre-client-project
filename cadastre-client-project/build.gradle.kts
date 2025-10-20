plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("plugin.jpa") version "1.9.25"
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
}

dependencies {
	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// JPA (se for usar banco de dados)
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("com.h2database:h2")
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
