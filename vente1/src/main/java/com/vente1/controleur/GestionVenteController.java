package com.vente1.controleur;
import com.vente1.entite.Client;
import com.vente1.entite.Commande;
import com.vente1.entite.DetailCommande;
import com.vente1.entite.Produit;
import com.vente1.open.RestClient;
import com.vente1.repository.ClientRepository;
import com.vente1.repository.CommandeRepository;
import com.vente1.repository.DetailCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;@RestController
public class GestionVenteController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    DetailCommandeRepository detailCommandeRepository;
    RestClient restClient;
    public GestionVenteController(RestClient restClient) {
        this.restClient = restClient;
    }
    // Endpoint pour créer un nouveau client
    @PostMapping("/clients")
    public Client creerClient(@RequestBody Client client) {
        // Enregistre un nouveau client
        return clientRepository.save(client);
    }
    // Endpoint pour récupérer la liste de tous les clients
    @GetMapping("/clients")
    public List<Client> listerTousLesClients() {
        // Retourne la liste de tous les clients
        return clientRepository.findAll();
    }
    // Endpoint pour récupérer un client spécifique par son ID
    @GetMapping("/clients/{id}")
    public Optional<Client> recupererClient(@PathVariable Long id) {
        // Récupère un client à partir de son ID
        return clientRepository.findById(id);
    }
    // Endpoint pour supprimer un client par son ID
    @DeleteMapping("/clients/{id}")
    public void supprimerClient(@PathVariable Long id) {
        // Supprime un client à partir de son ID
        clientRepository.deleteById(id);
    }
    // Endpoint pour créer une nouvelle commande pour un client spécifique
    @PostMapping("/clients/{clientId}/commandes")
    public Commande creerCommande(@PathVariable Long clientId, @RequestBody Commande commande) {
        // Crée une nouvelle commande associée à un client existant
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if (clientOpt.isPresent()) {
            commande.setClient(clientOpt.get());
            commande.setEtats("impaye");
            return commandeRepository.save(commande);
        } else {
            throw new RuntimeException("Client non trouvé");
        }
    }
    // Endpoint pour récupérer la liste de toutes les commandes
    @GetMapping("/commandes")
    public List<Commande> listerToutesLesCommandes() {
        // Retourne la liste de toutes les commandes
        return commandeRepository.findAll();
    }

    @GetMapping("/commandes/{id}")
    public Optional<Commande> getCommande(@PathVariable Long id)
    {
        // Récupère un client à partir de son ID
        return commandeRepository.findById(id);
    }

    // Endpoint pour créer un nouveau détail de commande pour une commande spécifique
    @PostMapping("/commandes/{commandeId}/details")
    public DetailCommande creerDetailCommande(@PathVariable Long commandeId, @RequestBody DetailCommande detailCommande) {
        // Crée un nouveau détail de commande pour une commande existante
        Optional<Commande> commandeOpt = commandeRepository.findById(commandeId);
        if (commandeOpt.isPresent()) {
            Produit produit=restClient.getProductById(detailCommande.getProduitId());
            detailCommande.setProduit(produit);
            int nouvStock=produit.getQuantite()-detailCommande.getQuantite();
            restClient.updateStock(produit.getId(), nouvStock);
            detailCommande.setCommande(commandeOpt.get());
            return detailCommandeRepository.save(detailCommande);
        } else {
            throw new RuntimeException("Commande n'existe pas");
        }
    }
    // Endpoint pour récupérer les détails d'une commande spécifique par son ID
    @GetMapping("/commandes/{commandeId}/details/{detailId}")
    public DetailCommande getDetailsCommande(@PathVariable Long commandeId, @PathVariable Long detailId) {
        // Récupère les détails d'une commande spécifique
        DetailCommande detailCommande=detailCommandeRepository.findById(detailId).get();
        Produit produit=restClient.getProductById(detailCommande.getProduitId());
        detailCommande.setProduit(produit);
        return detailCommande;
    }
    @PutMapping(value = "/commandes/{id}")
    public String updatEtatComm(@PathVariable Long id) {
        Optional<Commande> commOptional = commandeRepository.findById(id);
        if (commOptional.isPresent()) {
            Commande commande = commOptional.get();
            commande.setEtats("paye"); // Mettre à jour le stock
            commandeRepository.save(commande); // Sauvegarder le produit avec le stock mis à jour
            return "Stock mis à jour pour le produit avec l'ID " + id;
        } else {
            return "Produit avec l'ID " + id + " non trouvé";
        }
    }
    @GetMapping("/commandes/{commandeId}/listdetails")
    public List<DetailCommande> listDetailsCommande()
    {
        List<DetailCommande> detailCommandes=detailCommandeRepository.findAll();
        List<Produit> produitList=restClient.getProducts();
        produitList.forEach(produit -> {
            detailCommandes.forEach(detailCommande -> {
                if(produit.getId()==detailCommande.getProduitId())
                {
                    detailCommande.setProduit(produit);
                }
            });
        });return detailCommandes;
    }
    @GetMapping("/plus-vendu")
    public Produit getProduitLePlusVendu() {
        Long produitId = detailCommandeRepository.findMostSoldProductId();
        return restClient.getProductById(produitId);
    }
}
