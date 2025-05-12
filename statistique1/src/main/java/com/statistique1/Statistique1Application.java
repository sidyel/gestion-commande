package com.statistique1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class Statistique1Application {

	public static void main(String[] args) {
		SpringApplication.run(Statistique1Application.class, args);
	}

}
