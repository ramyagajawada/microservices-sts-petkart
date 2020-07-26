package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class AdminnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminnApplication.class, args);
	}

}
