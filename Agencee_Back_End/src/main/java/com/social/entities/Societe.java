 package com.social.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "societe")
public class Societe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	private String nomS;
	private int siret;
	private int tel;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "societe")
   private Set<Adherant> adherants = new HashSet<>();
	
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Societe(String nomS, int siret, int tel) {
		super();
		this.nomS = nomS;
		this.siret = siret;
		this.tel = tel;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNomS() {
		return nomS;
	}

	public void setNomS(String nomS) {
		this.nomS = nomS;
	}

	public int getSiret() {
		return siret;
	}

	public void setSiret(int siret) {
		this.siret = siret;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}
	
	

}
