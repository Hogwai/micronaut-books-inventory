package com.hogwai.micronaut

import groovy.transform.CompileStatic
import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
        info = @Info(
                title = "Book API",
                version = "1.0",
                description = "API for books handling"
        )
)
class Application {

    static void main(String[] args) {
        Micronaut.run(Application, args)
    }
}
