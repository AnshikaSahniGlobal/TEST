package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbAssigmentDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbAssigmentDockerApplication.class, args);
		System.out.println("Server Started..");
		
	}
	@GetMapping("/hello")
	public String sayHello() {
		
		return "Welcome to Docker Application For Assignment 4";
	}

}
