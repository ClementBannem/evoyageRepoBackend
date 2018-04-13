package com.social.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Avion")
public class Avion extends Voyage {
	
	private String aeroport_Depart;
	private String aeroport_Arrive;


	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avion(String escale,String libelle, String date_Depart, String date_Arrive, String heure_Depart, String heure_Arrive,
			double prix,String compagnie) {
		super(escale,libelle, date_Depart, date_Arrive, heure_Depart, heure_Arrive, prix,compagnie);
		// TODO Auto-generated constructor stub
	}
	
	
	public Avion(String escale,String libelle, String date_Depart, String date_Arrive, String heure_Depart, String heure_Arrive,
			double prix, String aeroport_Depart, String aeroport_Arrive, String compagnie) {
		super(escale,libelle, date_Depart, date_Arrive, heure_Depart, heure_Arrive, prix,compagnie);
		this.aeroport_Depart = aeroport_Depart;
		this.aeroport_Arrive = aeroport_Arrive;
	}
	public String getAeroport_Depart() {
		return aeroport_Depart;
	}
	public void setAeroport_Depart(String aeroport_Depart) {
		this.aeroport_Depart = aeroport_Depart;
	}
	public String getAeroport_Arrive() {
		return aeroport_Arrive;
	}
	public void setAeroport_Arrive(String aeroport_Arrive) {
		this.aeroport_Arrive = aeroport_Arrive;
	}
	
}
