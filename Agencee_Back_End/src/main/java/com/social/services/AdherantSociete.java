package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.AdherantRepository;
import com.social.entities.Adherant;


@Service("AdherantSociete")
public class AdherantSociete {


	private AdherantRepository adherantRepository;

	@Autowired
	public AdherantSociete(AdherantRepository adherantRepository) {
		this.adherantRepository = adherantRepository;
	}
	
	public Adherant save(Adherant adherant) {
		return adherantRepository.save(adherant);
	}
	
}
