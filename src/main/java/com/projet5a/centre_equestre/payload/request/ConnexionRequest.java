package com.projet5a.centre_equestre.payload.request;

import javax.validation.constraints.NotBlank;

public class ConnexionRequest {
	@NotBlank
	private String nom;

	@NotBlank
	private String motDePasse;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
