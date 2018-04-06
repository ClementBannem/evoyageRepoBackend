package com.social.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Gite")
public class Gite extends Hebergement {

	private String typeGite;
	private int nbrEtage;
	private int nbrChambres;

	public Gite() {
		super();
	}

	public Gite(String libelle, String adresse, String pays, String ville, int codePostal, float prix,
			String classement, String repas) {
		super(libelle, adresse, pays, ville, codePostal, prix, classement, repas);
	}

	public Gite(String libelle, String adresse, String pays, String ville, int codePostal, float prix,
			String classement, String repas, String typeGite, int nbrEtage, int nbrChambres) {
		super(libelle, adresse, pays, ville, codePostal, prix, classement, repas);
		this.typeGite = typeGite;
		this.nbrEtage = nbrEtage;
		this.nbrChambres = nbrChambres;
	}

	public String getTypeGite() {
		return typeGite;
	}

	public void setTypeGite(String typeGite) {
		this.typeGite = typeGite;
	}

	public int getNbrEtage() {
		return nbrEtage;
	}

	public void setNbrEtage(int nbrEtage) {
		this.nbrEtage = nbrEtage;
	}

	public int getNbrChambres() {
		return nbrChambres;
	}

	public void setNbrChambres(int nbrChambres) {
		this.nbrChambres = nbrChambres;
	}

}
