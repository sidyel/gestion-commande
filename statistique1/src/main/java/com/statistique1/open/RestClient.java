package com.statistique1.open;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "VENTE1")
public interface RestClient {

    @GetMapping("/plus-vendu")
    public Produit getProduitLePlusVendu();

}