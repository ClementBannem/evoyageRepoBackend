package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.ResidenceHoteliereRepository;
import com.social.entities.Residence_Hoteliere;

@Service
public class ResidenceHoteliereService {
	
	@Autowired
	ResidenceHoteliereRepository rhrepo;
	
	public Residence_Hoteliere save(Residence_Hoteliere residence_Hoteliere) {
		return rhrepo.saveAndFlush(residence_Hoteliere);
	}
	
	public Residence_Hoteliere update(Residence_Hoteliere residence_Hoteliere) {
		return rhrepo.save(residence_Hoteliere);
	}
	
//	public Residence_Hoteliere find(String libelle) {
//		return rhrepo.findOnebyLibelle(libelle);
//	}

}
