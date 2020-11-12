package com.projet5a.centre_equestre.model;

import javax.persistence.*;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;            // pas nullable ni vide (à ajouter dans le formulaire du front)
    private String email;       // pas nullable ni vide (à ajouter dans le formulaire du front)
    private String motDePasse;  // pas nullable ni vide (à ajouter dans le formulaire du front)
    private String nom;         // pas nullable ni vide (à ajouter dans le formulaire du front)
    private String prenom;      // pas nullable ni vide (à ajouter dans le formulaire du front)
    private String numero;      // pas nullable ni vide (à ajouter dans le formulaire du front)
    private String licence;
    private String role;

    public Utilisateur(){}

    public Utilisateur(String email, String motDePasse, String nom, String prenom, String numero, String licence, String role){
        this.email = email;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.licence = licence;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("Utilisateur[id=%d, email='%s', motDePasse='%s', nom='%s', prenom='%s', numero='%s', licence='%s', role='%s']",id, email, motDePasse, nom, prenom, numero, licence, role);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumero() {
        return numero;
    }

    public String getLicence() {
        return licence;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
