package com.social.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idR;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "client_id", nullable = true)
	private Long client_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offre_id", nullable = true)
	private Offre offre;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voyage_id", nullable = true)
	private Voyage voyage;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hebergement_id", nullable = true)
	private Hebergement hebergement;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evenement_id", nullable = true)
	private Evenement evenement;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Long client_id, Offre offre, Voyage voyage, Hebergement hebergement, Evenement evenement
			) {
		super();
		this.client_id = client_id;
		this.offre = offre;
		this.voyage = voyage;
		this.hebergement = hebergement;
		this.evenement = evenement;

	}

	public int getIdR() {
		return idR;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
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

}
