package dwsc.activity5swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

        @Value("${title}")
        private String title;

        @Value("${description}")
        private String description;

        @Value("${name}")
        private String name;

        @Value("${url}")
        private String url;

        @Value("${email}")
        private String email;

        @Value("${version}")
        private String version;

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                                .components(new Components())
                                .info(new Info()
                                                .title(title)
                                                .description(description)
                                                .contact(new Contact().name(name)
                                                                .url(url)
                                                                .email(email))
                                                .version(version));
        }
}