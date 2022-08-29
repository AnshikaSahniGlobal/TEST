package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SbAssigmentClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbAssigmentClientApplication.class, args);
	}
	 @GetMapping

	 public String hello() {

	 return "Eureka Client Application For Assignment 4";

	 }

}
