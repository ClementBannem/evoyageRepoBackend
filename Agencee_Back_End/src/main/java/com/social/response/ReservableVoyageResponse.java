package com.social.response;

import com.social.model.Links;

public class ReservableVoyageResponse {

	public Long id;

	private String escale;

	private String libelle;

	private String date_Depart;

	private String date_Arrive;

	private String Heure_Depart;

	private String Heure_Arrive;

	private double prix;

	private String compagnie;

	private String paysDepart;

	private String villeDepart;

	private String paysArrive;

	private String villeArrive;
	
	private Links links;

	public ReservableVoyageResponse() {
		super();
	}

	public ReservableVoyageResponse(String escale, String libelle, String date_Depart, String date_Arrive,
			String heure_Depart, String heure_Arrive, double prix, String compagnie, String paysDepart,
			String villeDepart, String paysArrive, String villeArrive) {
		super();
		this.escale = escale;
		this.libelle = libelle;
		this.date_Depart = date_Depart;
		this.date_Arrive = date_Arrive;
		Heure_Depart = heure_Depart;
		Heure_Arrive = heure_Arrive;
		this.prix = prix;
		this.compagnie = compagnie;
		this.paysDepart = paysDepart;
		this.villeDepart = villeDepart;
		this.paysArrive = paysArrive;
		this.villeArrive = villeArrive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEscale() {
		return escale;
	}

	public void setEscale(String escale) {
		this.escale = escale;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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

	public String getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	public String getPaysDepart() {
		return paysDepart;
	}

	public void setPaysDepart(String paysDepart) {
		this.paysDepart = paysDepart;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getPaysArrive() {
		return paysArrive;
	}

	public void setPaysArrive(String paysArrive) {
		this.paysArrive = paysArrive;
	}

	public String getVilleArrive() {
		return villeArrive;
	}

	public void setVilleArrive(String villeArrive) {
		this.villeArrive = villeArrive;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

}
