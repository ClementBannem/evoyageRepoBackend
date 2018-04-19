package com.social.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "adherants")
public class Adherant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idA;
	@Column(name = "nom")
	@NotNull
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "email")
	private String email;

	@Column(name = "num_portable")
	private long portable;

	@Column(name = "num_domicile")
	private long domicile;

	@Column(name = "sexe")
	private String sexe;

	@Column(name = "date_naissance")
	private String date_naissance;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "code_postale")
	private int code_postale;

	@Column(name = "ville")
	private String ville;

	@Column(name = "pays")
	private String pays;
	
	private String typeAdherant;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adherant_id", nullable = false)
	private Societe societe;

	public Adherant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adherant(String nom, String prenom, String email, long portable, long domicile, String sexe,
			String date_naissance, String adresse, int code_postale, String ville, String pays,String typeAdherant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.portable = portable;
		this.domicile = domicile;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.code_postale = code_postale;
		this.ville = ville;
		this.pays = pays;
	}

	public Long getIdA() {
		return idA;
	}

	public void setIdA(Long idA) {
		this.idA = idA;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPortable() {
		return portable;
	}

	public void setPortable(long portable) {
		this.portable = portable;
	}

	public long getDomicile() {
		return domicile;
	}

	public void setDomicile(long domicile) {
		this.domicile = domicile;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(int code_postale) {
		this.code_postale = code_postale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTypeAdherant() {
		return typeAdherant;
	}

	public void setTypeAdherant(String typeAdherant) {
		this.typeAdherant = typeAdherant;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	
	
}
