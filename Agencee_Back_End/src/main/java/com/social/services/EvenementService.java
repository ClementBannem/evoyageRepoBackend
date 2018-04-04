package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.EvenementRepository;
import com.social.entities.Evenement;

@Service("EvenementService")
public class EvenementService {
	

	private EvenementRepository evenementRepository;

	@Autowired
	public EvenementService(EvenementRepository evenementRepository) {
		this.evenementRepository = evenementRepository;
	}
	
	public Evenement save(Evenement evens) {
		return evenementRepository.save(evens);
	}
	

}
