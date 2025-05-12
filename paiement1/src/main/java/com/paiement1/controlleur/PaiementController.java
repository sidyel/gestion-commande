package com.paiement1.controlleur;
import com.paiement1.entite.Commande;
import com.paiement1.entite.Paiement;
import com.paiement1.repository.PaiementRepository;
import com.paiement1.restClient.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PaiementController {
    @Autowired
    PaiementRepository paiementRepository;
    @Autowired
    RestClient restClient;
    @PostMapping("/paiements")
    public Paiement creerPaiement(@RequestBody Paiement paiement) {
        Optional<Commande> commande=restClient.getCommande(paiement.getCommandeId());
        Commande commande1=commande.get();
        restClient.updatEtatComm(commande1.getId());
        commande1.setEtats("paye");
        paiement.setCommande(commande1);
        Paiement paiementf = paiementRepository.save(paiement);  // Correction ici
        return paiementf;
    }
    @GetMapping("/paiements/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        Paiement paiement = paiementRepository.findById(id).get();
        return paiement;
    }

    @GetMapping("/paiements")
    public List<Paiement> getAllPaiements() {
        List<Paiement> paiements = paiementRepository.findAll();
        return paiements;
    }

    @GetMapping("/montant-total")
    public Double getMontantTotalVentes() {
        return paiementRepository.getTotalMontantVentes();
    }

}
