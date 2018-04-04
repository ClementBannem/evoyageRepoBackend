package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.BateauRepository;
import com.social.entities.Bateau;




@Service("BateauService")
public class BateauService {
	
	private BateauRepository bateauRepository;

	@Autowired
	public BateauService(BateauRepository bateauRepository) {
		this.bateauRepository = bateauRepository;
	}
	
	public Bateau save(Bateau bateau) {
		return bateauRepository.save(bateau);
	}
	
	/*public Bateau update(Bateau bateau) {
		return bateauRepository.save(bateau);
	}
	
	public Bateau find(String nom) {
		return bateauRepository.findOneByNom(nom);
	}
	
	public Bateau find(int id) {
		return bateauRepository.findOne((long) id);
	}*/
}
