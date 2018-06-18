package com.social.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evenement")
public class Evenement implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idE;
	private String typeE;
	private String dateE;
	private String heure_deb;
	private String heure_fin;
	private double prixE;
	private String description;
	
	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Evenement(String typeE, String dateE, String heure_deb, String heure_fin, double prixE,String description) {
		super();
		this.typeE = typeE;
		this.dateE = dateE;
		this.heure_deb = heure_deb;
		this.heure_fin = heure_fin;
		this.prixE = prixE;
		this.description = description;
	}


	public long getIdE() {
		return idE;
	}

	public void setIdE(int idE) {
		this.idE = idE;
	}

	public String getTypeE() {
		return typeE;
	}

	public void setTypeE(String typeE) {
		this.typeE = typeE;
	}

	public double getPrixE() {
		return prixE;
	}

	public void setPrixE(double prixE) {
		this.prixE = prixE;
	}


	public String getDateE() {
		return dateE;
	}


	public void setDateE(String dateE) {
		this.dateE = dateE;
	}


	public String getHeure_deb() {
		return heure_deb;
	}


	public void setHeure_deb(String heure_deb) {
		this.heure_deb = heure_deb;
	}


	public String getHeure_fin() {
		return heure_fin;
	}


	public void setHeure_fin(String heure_fin) {
		this.heure_fin = heure_fin;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Evenement [idE=" + idE + ", typeE=" + typeE + ", dateE=" + dateE + ", heure_deb=" + heure_deb
				+ ", heure_fin=" + heure_fin + ", prixE=" + prixE + ", description=" + description + "]";
	}
	
	
	
	

}
