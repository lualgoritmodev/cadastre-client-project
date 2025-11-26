package com.garcia.luciano.cadastre_client_project.security

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme

@SecurityScheme(
    name = "bearerAuth", type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT", scheme = "bearer")
@OpenAPIDefinition(
    security = [SecurityRequirement(name = "bearerAuth")]
)
class SwaggerConfig