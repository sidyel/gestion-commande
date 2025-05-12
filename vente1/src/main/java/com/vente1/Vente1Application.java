package com.vente1;

import com.vente1.entite.Client;
import com.vente1.entite.Commande;
import com.vente1.entite.DetailCommande;
import com.vente1.repository.ClientRepository;
import com.vente1.repository.CommandeRepository;
import com.vente1.repository.DetailCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class Vente1Application implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	DetailCommandeRepository detailCommandeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Vente1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Client c1 = clientRepository.save(new Client("ass dione", "sisdhhjb", "n,ddfdf"));
		Commande com = commandeRepository.save(new Commande(c1, new Date()));
		DetailCommande dc = detailCommandeRepository.save(new DetailCommande(com, 3, 5));*/
	}
}
