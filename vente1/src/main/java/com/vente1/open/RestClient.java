package com.vente1.open;


import com.vente1.entite.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "PRODUIT1")
public interface RestClient {

    @GetMapping(value = "/produits/{id}")
    public Produit getProductById(@PathVariable Long id);

    @GetMapping(value="/produits")
    public List<Produit> getProducts();

    @PutMapping(value = "/produits/{id}/maj")
    public String updateStock(@PathVariable Long id, @RequestBody int newStock);

}
