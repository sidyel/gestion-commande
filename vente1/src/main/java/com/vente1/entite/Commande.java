package com.vente1.entite;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Commande(Client client, Date dateCommande) {
        this.client = client;
        this.dateCommande = dateCommande;
    }

    public Commande() {
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private Date dateCommande;
    private String etats;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtats() {
        return etats;
    }

    public void setEtats(String etats) {
        this.etats = etats;
    }
}
