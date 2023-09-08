package com.api.javaparkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JavaParkingControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaParkingControlApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Aplicação no ar! Ficou Top!";
	}
}
