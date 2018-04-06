package com.social.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Hebergement")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_Hebergement", discriminatorType = DiscriminatorType.STRING, length = 30)
public class Hebergement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String libelle;
	private String adresse;
	private String pays;
	private String ville;
	private int codePostal;
	private float prix;
	private String classement;
	private String repas;

	public Hebergement(String libelle, String adresse, String pays, String ville, int codePostal, float prix,
			String classement, String repas) {
		super();
		this.libelle = libelle;
		this.adresse = adresse;
		this.pays = pays;
		this.ville = ville;
		this.codePostal = codePostal;
		this.prix = prix;
		this.classement = classement;
		this.repas = repas;
	}

	public Hebergement() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getClassement() {
		return classement;
	}

	public void setClassement(String classement) {
		this.classement = classement;
	}

	public String getRepas() {
		return repas;
	}

	public void setRepas(String repas) {
		this.repas = repas;
	}

	@Override
	public String toString() {
		return "Hebergement [libelle=" + libelle + ", adresse=" + adresse + ", pays=" + pays + ", ville=" + ville
				+ ", codePostal=" + codePostal + ", prix=" + prix + ", classement=" + classement + ", repas=" + repas
				+ "]";
	}

}
