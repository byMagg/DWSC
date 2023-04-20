package dwsc.activity4swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Activity 4 API")
                        .description("API description for Activity4.")
                        .contact(new Contact().name("Daniel Barroso")
                                .url("https://github.com/byMagg")
                                .email("dbu104@inlumine.ual.es"))
                        .version("0.0.1"));
    }
}