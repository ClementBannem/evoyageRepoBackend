package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.GiteRepository;
import com.social.entities.Gite;

@Service
public class GiteService {
	
	@Autowired
	GiteRepository giterepository;
	
	public Gite save(Gite gite) {
		return giterepository.saveAndFlush(gite);
	}
	
	public Gite update(Gite gite) {
		return giterepository.save(gite);
	}
	
//	public Gite find(String libelle) {
//		return giterepository.findOnebyLibelle(libelle);
//	}

}
