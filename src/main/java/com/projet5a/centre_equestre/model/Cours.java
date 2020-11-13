package com.projet5a.centre_equestre.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String intitule;
    private String date;
    private String heure;
    private int galop;

    protected Cours() {}

    public Cours(String intitule, String date, String heure, int galop) {
        this.intitule = intitule;
        this.date = date;
        this.heure = heure;
        this.galop = galop;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, intitulé='%s', date='%s', heure='%s', galop='%d']",
                id, intitule, date, heure, galop);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setGalop(int galop) {
        this.galop = galop;
    }

    public Long getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public int getGalop() {
        return galop;
    }
}