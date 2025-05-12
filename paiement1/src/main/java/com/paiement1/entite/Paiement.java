package com.paiement1.entite;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date datePaiement;


    private Long commandeId;  // Référence à la commande correspondante


    private Double montant;

    @Transient
    private  Commande commande;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Long commandeId) {
        this.commandeId = commandeId;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Paiement(Long commandeId, Double montant, Date datePaiement) {
        this.commandeId = commandeId;
        this.montant = montant;
        this.datePaiement = datePaiement;
    }

    public Paiement() {
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }



}
