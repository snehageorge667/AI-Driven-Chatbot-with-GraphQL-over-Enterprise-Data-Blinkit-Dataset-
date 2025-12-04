package com.example.blinkit.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI blinkitOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Blinkit Grocery API")
                        .description("REST API for managing grocery items with free search, CRUD operations")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository")
                        .url("https://github.com/yourusername/blinkit-springboot"));
    }
}
