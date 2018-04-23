package com.social.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Bateau")
public class Bateau extends Voyage {

	private String quai_Depart;
	private String quai_Arrive;

	public Bateau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bateau(String escale, String libelle, String date_Depart, String date_Arrive, String heure_Depart,
			String heure_Arrive, double prix, String compagnie, String paysDepart, String villeDepart,
			String paysArrive, String villeArrive) {
		super(escale, libelle, date_Depart, date_Arrive, heure_Depart, heure_Arrive, prix, compagnie, paysDepart,
				villeDepart, paysArrive, villeArrive);
		// TODO Auto-generated constructor stub
	}

	public Bateau(String escale, String libelle, String date_Depart, String date_Arrive, String heure_Depart,
			String heure_Arrive, double prix, String compagnie, String paysDepart, String villeDepart,
			String paysArrive, String villeArrive, String quai_Depart, String quai_Arrive) {
		super(escale, libelle, date_Depart, date_Arrive, heure_Depart, heure_Arrive, prix, compagnie, paysDepart,
				villeDepart, paysArrive, villeArrive);
		this.quai_Depart = quai_Depart;
		this.quai_Arrive = quai_Arrive;
	}

	public String getQuai_Depart() {
		return quai_Depart;
	}

	public void setQuai_Depart(String quai_Depart) {
		this.quai_Depart = quai_Depart;
	}

	public String getQuai_Arrive() {
		return quai_Arrive;
	}

	public void setQuai_Arrive(String quai_Arrive) {
		this.quai_Arrive = quai_Arrive;
	}

}
