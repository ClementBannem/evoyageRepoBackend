package com.social.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ResidenceHoteliere")
public class Residence_Hoteliere extends Hebergement {

	private int nbrEtage;
	private int nbrChambre;

	public Residence_Hoteliere() {
		super();
	}

	public Residence_Hoteliere(String libelle, String adresse, String pays, String ville, int codePostal, float prix,
			String classement, String repas) {
		super(libelle, adresse, pays, ville, codePostal, prix, classement, repas);
	}

	public Residence_Hoteliere(String libelle, String adresse, String pays, String ville, int codePostal, float prix,
			String classement, String repas, int nbrEtage, int nbrChambre) {
		super(libelle, adresse, pays, ville, codePostal, prix, classement, repas);
		this.nbrEtage = nbrEtage;
		this.nbrChambre = nbrChambre;
	}

	public int getNbrEtage() {
		return nbrEtage;
	}

	public void setNbrEtage(int nbrEtage) {
		this.nbrEtage = nbrEtage;
	}

	public int getNbrChambre() {
		return nbrChambre;
	}

	public void setNbrChambre(int nbrChambre) {
		this.nbrChambre = nbrChambre;
	}

}
