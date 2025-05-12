package com.vente1.entite;

import jakarta.persistence.*;

@Entity

public class DetailCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    private Long produitId;
    private Integer quantite;



    public DetailCommande() {
    }

    public DetailCommande(Commande commande, Long produitId, Integer quantite) {
        this.commande = commande;
        this.produitId = produitId;
        this.quantite = quantite;
    }



    @Transient
    private Produit produit;

    public DetailCommande(Commande com, double v, int quantite) {
        this.commande = com;
        this.produitId = (long) v;
        this.quantite = quantite;

    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Produit getProduit() {
        return produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}
