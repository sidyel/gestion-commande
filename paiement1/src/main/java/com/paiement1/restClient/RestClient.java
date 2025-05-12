package com.paiement1.restClient;


import com.paiement1.entite.Commande;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "VENTE1")
public interface RestClient {

    @GetMapping("/commandes/{id}")
    public Optional<Commande> getCommande(@PathVariable Long id);

    @PutMapping(value = "/commandes/{id}")
    public String updatEtatComm(@PathVariable Long id);

}
