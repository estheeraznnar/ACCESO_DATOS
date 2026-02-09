package org.iesch.DocumentosReferenciados.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://127.0.0.1:8080/swagger-ui/index.html
@Configuration
public class OpenApiconfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Api de prueba de mongodb")
                        .version("1.0.0")
                        .description("Pruebas realizadas para entender las consultas mejor en mongo"));
    }

}
