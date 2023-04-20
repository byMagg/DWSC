package dwsc.activity4swagger.config;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Value;
>>>>>>> f19116a36a4f58ebead523faac2f319d707fb7ce
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
<<<<<<< HEAD
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
=======

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
>>>>>>> f19116a36a4f58ebead523faac2f319d707fb7ce
}