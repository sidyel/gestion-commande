package com.paiement1.entite;


import java.util.Date;


public class Commande {

    private Long id;

    public Commande(Client client, Date dateCommande) {
        this.client = client;
        this.dateCommande = dateCommande;
    }

    public Commande() {
    }


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
