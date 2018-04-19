package com.social.entities;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idR;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
	private Client client;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offre_id", nullable = false)
	private Offre offre;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voyage_id", nullable = false)
	private Voyage voyage;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hebergement_id", nullable = false)
	private Hebergement hebergement;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evenement_id", nullable = false)
	private Evenement evenement;
	
	private String dateD;
	private String dateA;
	private String heureD;
	private String heureA;
	private String paysD;
	private String paysA;
	private String villeD;
	private String villeA;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Client client, Offre offre, Voyage voyage, Hebergement hebergement, Evenement evenement,
			String dateD, String dateA, String heureD, String heureA, String paysD, String paysA, String villeD,
			String villeA) {
		super();
		this.client = client;
		this.offre = offre;
		this.voyage = voyage;
		this.hebergement = hebergement;
		this.evenement = evenement;
		this.dateD = dateD;
		this.dateA = dateA;
		this.heureD = heureD;
		this.heureA = heureA;
		this.paysD = paysD;
		this.paysA = paysA;
		this.villeD = villeD;
		this.villeA = villeA;
	}

	public int getIdR() {
		return idR;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public Hebergement getHebergement() {
		return hebergement;
	}

	public void setHebergement(Hebergement hebergement) {
		this.hebergement = hebergement;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public String getDateD() {
		return dateD;
	}

	public void setDateD(String dateD) {
		this.dateD = dateD;
	}

	public String getDateA() {
		return dateA;
	}

	public void setDateA(String dateA) {
		this.dateA = dateA;
	}

	public String getHeureD() {
		return heureD;
	}

	public void setHeureD(String heureD) {
		this.heureD = heureD;
	}

	public String getHeureA() {
		return heureA;
	}

	public void setHeureA(String heureA) {
		this.heureA = heureA;
	}

	public String getPaysD() {
		return paysD;
	}

	public void setPaysD(String paysD) {
		this.paysD = paysD;
	}

	public String getPaysA() {
		return paysA;
	}

	public void setPaysA(String paysA) {
		this.paysA = paysA;
	}

	public String getVilleD() {
		return villeD;
	}

	public void setVilleD(String villeD) {
		this.villeD = villeD;
	}

	public String getVilleA() {
		return villeA;
	}

	public void setVilleA(String villeA) {
		this.villeA = villeA;
	}
	
	

}
