package dwsc.activity4.config;

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
                        .title("Test API")
                        .description("Some custom description of API.")
                        .contact(new Contact().name("Javier Criado")
                                .url("https://www.ual.es/persona/525353565157505083").email("javi.criado@ual.es"))
                        .version("0.0.1"));
    }
}