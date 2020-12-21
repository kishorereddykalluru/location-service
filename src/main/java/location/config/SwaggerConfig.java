package location.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI locationOpenApi(){
        return new OpenAPI().info(
                new Info().title("Address Service")
                .description("Retreive addresses based on country"));
    }
}
