package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.OffreRepository;
import com.social.entities.Offre;



@Service("OffreService")
public class OffreService {

	private OffreRepository offreRepository;

	@Autowired
	public OffreService(OffreRepository offreRepository) {
		this.offreRepository = offreRepository;
	}
	
	public Offre save(Offre offre) {
		return offreRepository.save(offre);
	}
}
