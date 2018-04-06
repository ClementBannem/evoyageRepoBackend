package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.CampingRepository;
import com.social.entities.Camping;

@Service
public class CampingService {
	
	@Autowired
	CampingRepository camR;
	
	public Camping save(Camping camping) {
		return camR.saveAndFlush(camping);
	}
	
	public Camping update(Camping camping) {
		return camR.save(camping);
	}
	
//	public Camping find(String libelle) {
//		return camR.findOnebyLibelle(libelle);
//	}
	
}
