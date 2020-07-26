package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication

public class Petkart3Application {

	public static void main(String[] args) {
		SpringApplication.run(Petkart3Application.class, args);
	}

}
