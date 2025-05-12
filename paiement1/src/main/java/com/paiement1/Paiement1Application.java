package com.paiement1;

import com.paiement1.entite.Paiement;
import com.paiement1.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class Paiement1Application implements CommandLineRunner {

	@Autowired
	PaiementRepository paiementRepository;

	public static void main(String[] args) {
		SpringApplication.run(Paiement1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Paiement paiement=paiementRepository.save(new Paiement((long) 1.0, 3000.0,new Date()));
	}
}
