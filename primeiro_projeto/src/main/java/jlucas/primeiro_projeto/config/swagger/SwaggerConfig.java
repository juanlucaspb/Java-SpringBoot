package jlucas.primeiro_projeto.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Primeiro Projeto",
                version = "v1",
                description = "Criação de API com spring"
        )
)
public class SwaggerConfig {
}