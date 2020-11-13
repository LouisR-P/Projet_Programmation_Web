package com.projet5a.centre_equestre.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class InscriptionRequest {

    private String email;
    @NotBlank
    @Size(min = 6, max = 40)
    private String motDePasse;
    private String nom;
    private String prenom;
    private String numero;
    private String licence;
    
    private Set<String> role;

    private String password;

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
