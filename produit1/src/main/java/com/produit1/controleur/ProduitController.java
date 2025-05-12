package com.produit1.controleur;

import com.produit1.entite.Produit;
import com.produit1.repository.ProduitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProduitController {

    @Autowired
    ProduitRepository productRepository;

    // Récupérer tous les produits
    @GetMapping(value="/produits")
    public List<Produit> getProducts() {
        return productRepository.findAll();
    }

    // Ajouter un nouveau produit
    @PostMapping(value = "/ajouter")
    public Produit addProduct(@RequestBody Produit product) {

        return  productRepository.save(product);
    }
    // Récupérer un produit par son ID
    @GetMapping(value = "/produits/{id}")
    public Produit getProductById(@PathVariable Long id) {
        Optional<Produit> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RuntimeException("Produit avec l'ID " + id + " non trouvé");
        }
    }
    // Mettre à jour le stock d'un produit après une commande
    @PutMapping(value = "/produits/{id}/maj")
    public Produit updateProductStock(@PathVariable Long id, @RequestBody int newStock) {
        Optional<Produit> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Produit product = productOptional.get();
            product.setQuantite(newStock); // Mettre à jour le stock
            // Sauvegarder le produit avec le stock mis à jour
            return  productRepository.save(product);
        } else {
            return null;
        }
    }
    // Supprimer un produit par son ID
    @DeleteMapping(value = "/produits/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Optional<Produit> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return "Produit supprimé avec succès";
        } else {
            return "Produit avec l'ID " + id + " non trouvé";
        }
    }
    @PutMapping(path = "/produits/{code}")
    public Produit update(@PathVariable Long code , @RequestBody Produit produit)
    {
        produit.setId(code);
        return productRepository.save(produit);
    }
}
