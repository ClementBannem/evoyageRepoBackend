package com.social.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Transport")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_Transport",discriminatorType=DiscriminatorType.STRING,length=30)

public class Transport implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "escale")
	private String escale;

	@Column(name = "date_Depart")
	private String date_Depart;

	@Column(name = "date_Arrive")
	private String date_Arrive;

	@Column(name = "Heure_Depart")
	private String Heure_Depart;

	@Column(name = "Heure_Arrive")
	private String Heure_Arrive;

	@Column(name = "prix")
	private double prix;

	public Transport(String escale, String date_Depart, String date_Arrive, String heure_Depart, String heure_Arrive,
			double prix) {
		super();
		this.escale = escale;
		this.date_Depart = date_Depart;
		this.date_Arrive = date_Arrive;
		Heure_Depart = heure_Depart;
		Heure_Arrive = heure_Arrive;
		this.prix = prix;
	}

	public Transport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String isEscale() {
		return escale;
	}

	public void setEscale(String escale) {
		this.escale = escale;
	}

	public String getDate_Depart() {
		return date_Depart;
	}

	public void setDate_Depart(String date_Depart) {
		this.date_Depart = date_Depart;
	}

	public String getDate_Arrive() {
		return date_Arrive;
	}

	public void setDate_Arrive(String date_Arrive) {
		this.date_Arrive = date_Arrive;
	}

	public String getHeure_Depart() {
		return Heure_Depart;
	}

	public void setHeure_Depart(String heure_Depart) {
		Heure_Depart = heure_Depart;
	}

	public String getHeure_Arrive() {
		return Heure_Arrive;
	}

	public void setHeure_Arrive(String heure_Arrive) {
		Heure_Arrive = heure_Arrive;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	

}
