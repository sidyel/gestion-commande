package com.statistique1.controlleur;

import com.statistique1.open.Produit;
import com.statistique1.open.RestClient;
import com.statistique1.open.RestPAiement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatistiqueController {
    @Autowired
    RestClient restClient;

    @Autowired
    RestPAiement restPAiement;
    @GetMapping("/statistique/produitPlusVendus")
    public Produit produitPlusVendus() {
        Produit produit = restClient.getProduitLePlusVendu();
        return produit;
    }
    @GetMapping("/statistique/montantTotal")
    public double getTotalMontantVentes() {
        return restPAiement.getMontantTotalVentes();
    }
}
