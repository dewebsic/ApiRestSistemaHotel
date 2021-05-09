package com.angelsepulveda.apirestsistemahotel;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Api rest hotel", version = "1.0", description = "Api Rest para sistema de gestion hotel"))
public class ApiRestSistemaHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestSistemaHotelApplication.class, args);
    }

}
