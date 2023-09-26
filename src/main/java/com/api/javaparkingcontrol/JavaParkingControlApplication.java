package com.api.javaparkingcontrol;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "Java Parking Control",
        version = "1.0.0",
        description = "API para controle de estacionamento"
    ))
public class JavaParkingControlApplication {

  public static void main(String[] args) {
    SpringApplication.run(JavaParkingControlApplication.class, args);
  }

  @GetMapping("/")
  public String index() {
    return "Aplicação no ar!";
  }
}
