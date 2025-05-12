package com.produit1;

import com.produit1.entite.Produit;
import com.produit1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Produit1Application implements CommandLineRunner {

	@Autowired
	ProduitRepository produitRepository;

	public static void main(String[] args) {
		SpringApplication.run(Produit1Application.class, args);
	}

	public void run(String... args) throws Exception {

		/*produitRepository.save(new Produit("chocolat",8000,50,"dsddds"));
		produitRepository.save(new Produit("lait",8000,50,"dsddds"));
		produitRepository.save(new Produit("boisson",8000,50,"dd"));

		produitRepository.findAll().forEach(produit -> {
			System.out.println(produit.getNom());
			System.out.println(produit.getPrix());

		});*/


	}
}
