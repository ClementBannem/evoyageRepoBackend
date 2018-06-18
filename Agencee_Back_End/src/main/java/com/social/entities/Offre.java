package com.social.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table(name = "offre")
public class Offre implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idO;
	private String libelle;
	private String date_debut;
	private String date_fin;
	private String description;
	public Offre() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	public Offre(String libelle, String date_debut, String date_fin, String description) {
		super();
		this.libelle = libelle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.description = description;
	}
	public long getIdO() {
		return idO;
	}
	public void setIdO(long idO) {
		this.idO = idO;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
