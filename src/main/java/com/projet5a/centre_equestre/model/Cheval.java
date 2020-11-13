package com.projet5a.centre_equestre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cheval {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nom;
    private String race;
    private double poids;
    private double taille;

    protected Cheval() {}

    public Cheval(String nom, String race, double poids, double taille) {
        this.nom = nom;
        this.race = race;
        this.poids = poids;
        this.taille = taille;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, nom='%s', type='%s', poids='%d', taille='%d']",
                id, nom, race, poids, taille);
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getRace() {
        return race;
    }

    public double getPoids() {
        return poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }
}
