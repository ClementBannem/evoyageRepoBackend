package com.social.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nom")
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

	@Column(name = "numeroCB")
	private String numeroCB;

	@Column(name = "expirationCB")
	private String expirationCB;

//	@Column(name = "typeClient")
//	private String typeClient;

	@Column(name = "ajoute_par_utilisateur")
	private Long ajoutePar;
	
	@CreationTimestamp
    private Date created;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") // nullable = false
	private User user;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
//	private Set<Reservation> reservations = new HashSet<>();

	protected Client() {
	}

	public Client(String nom, String prenom, String email, long portable, long domicile, String sexe,
			String date_naissance, String adresse, int code_postale, String ville, String pays, String numeroCB,
			String expirationCB, String typeClient, User user, Long ajoutePar) {
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
		this.numeroCB = numeroCB;
		this.expirationCB = expirationCB;
		this.user = user;
		this.ajoutePar = ajoutePar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNumeroCB() {
		return numeroCB;
	}

	public void setNumeroCB(String numeroCB) {
		this.numeroCB = numeroCB;
	}

	public String getExpirationCB() {
		return expirationCB;
	}

	public void setExpirationCB(String expirationCB) {
		this.expirationCB = expirationCB;
	}

	public Long getAjoutePar() {
		return ajoutePar;
	}

	public void setAjoutePar(Long ajoutePar) {
		this.ajoutePar = ajoutePar;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", portable=" + portable
				+ ", domicile=" + domicile + ", sexe=" + sexe + ", date_naissance=" + date_naissance + ", adresse="
				+ adresse + ", code_postale=" + code_postale + ", ville=" + ville + ", pays=" + pays + ", numeroCB="
				+ numeroCB + ", expirationCB=" + expirationCB + ", typeClient=" + ", ajoutePar="
				+ ajoutePar + ", user=" + user  + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}