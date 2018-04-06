package com.social.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Camping")
public class Camping extends Hebergement {

	private String typeCamping;

	public Camping() {
		super();
	}

	public Camping(String libelle, String adresse, String pays, String ville, int codePostal, float prix,
			String classement, String repas) {
		super(libelle, adresse, pays, ville, codePostal, prix, classement, repas);
	}

	public Camping(String libelle, String adresse, String pays, String ville, int codePostal, float prix,
			String classement, String repas, String typeCamping) {
		super(libelle, adresse, pays, ville, codePostal, prix, classement, repas);
		this.typeCamping = typeCamping;
	}

	public String getTypeCamping() {
		return typeCamping;
	}

	public void setTypeCamping(String typeCamping) {
		this.typeCamping = typeCamping;
	}

}
