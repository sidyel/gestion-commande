package com.paiement1.entite;




public class Client {

    private Long id;

    public Client() {
    }

    private String nom;

    public Client( String nom, String email, String adresse) {

        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }

    private String email;
    private String adresse;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    // Getters et Setters
}
