package com.social.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "AutoCar")
public class AutoCar extends Voyage {
	private String gareAC_Depart;
	private String gareAC_Arrive;

	public AutoCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AutoCar(String escale, String libelle, String date_Depart, String date_Arrive, String heure_Depart,
			String heure_Arrive, double prix, String compagnie, String paysDepart, String villeDepart,
			String paysArrive, String villeArrive) {
		super(escale, libelle, date_Depart, date_Arrive, heure_Depart, heure_Arrive, prix, compagnie, paysDepart, villeDepart,
				paysArrive, villeArrive);
		// TODO Auto-generated constructor stub
	}



	public AutoCar(String escale, String libelle, String date_Depart, String date_Arrive, String heure_Depart,
			String heure_Arrive, double prix, String compagnie, String paysDepart, String villeDepart,
			String paysArrive, String villeArrive, String gareAC_Depart, String gareAC_Arrive) {
		super(escale, libelle, date_Depart, date_Arrive, heure_Depart, heure_Arrive, prix, compagnie, paysDepart,
				villeDepart, paysArrive, villeArrive);
		this.gareAC_Depart = gareAC_Depart;
		this.gareAC_Arrive = gareAC_Arrive;
	}



	public String getGareAC_Depart() {
		return gareAC_Depart;
	}

	public void setGareAC_Depart(String gareAC_Depart) {
		this.gareAC_Depart = gareAC_Depart;
	}

	public String getGareAC_Arrive() {
		return gareAC_Arrive;
	}

	public void setGareAC_Arrive(String gareAC_Arrive) {
		this.gareAC_Arrive = gareAC_Arrive;
	}

}
