package com.social.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Train")
public class Train extends Transport {
	private String gare_Depart;
	private String gare_Arrive;
	

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Train(String escale, String date_Depart, String date_Arrive, String heure_Depart, String heure_Arrive,
			double prix) {
		super(escale, date_Depart, date_Arrive, heure_Depart, heure_Arrive, prix);
		// TODO Auto-generated constructor stub
	}
	
	
	public Train(String escale, String date_Depart, String date_Arrive, String heure_Depart, String heure_Arrive,
			double prix, String gare_Depart, String gare_Arrive) {
		super(escale, date_Depart, date_Arrive, heure_Depart, heure_Arrive, prix);
		this.gare_Depart = gare_Depart;
		this.gare_Arrive = gare_Arrive;
	}
	public String getGare_Depart() {
		return gare_Depart;
	}
	public void setGare_Depart(String gare_Depart) {
		this.gare_Depart = gare_Depart;
	}
	public String getGare_Arrive() {
		return gare_Arrive;
	}
	public void setGare_Arrive(String gare_Arrive) {
		this.gare_Arrive = gare_Arrive;
	}
	
	

}
