package com.social.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Voyage")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_Voyage", discriminatorType = DiscriminatorType.STRING, length = 30)

public class Voyage implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@JsonIgnore
	@Column(name = "escale")
	private String escale;

	@Column(name = "libelle_voyage")
	private String libelle;

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

	@JsonIgnore
	@Column(name = "compagnie")
	private String compagnie;

	@Column(name = "pays_Depart")
	private String paysDepart;

	@Column(name = "ville_Depart")
	private String villeDepart;

	@Column(name = "pays_Arrive")
	private String paysArrive;

	@Column(name = "ville_Arrive")
	private String villeArrive;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "voyage")
	private Set<Reservation> reservations = new HashSet<>();

	public Voyage(String escale, String libelle, String date_Depart, String date_Arrive, String heure_Depart,
			String heure_Arrive, double prix, String compagnie, String paysDepart, String villeDepart,
			String paysArrive, String villeArrive) {
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
		// this.reservations = reservations;
	}

	public Voyage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getEscale() {
		return escale;
	}

	public void setEscale(String escale) {
		this.escale = escale;
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

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

}
