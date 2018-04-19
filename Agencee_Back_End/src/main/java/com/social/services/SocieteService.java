package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.SocieteRepository;
import com.social.entities.Societe;

@Service("SocieteService")
public class SocieteService {
	
	private SocieteRepository societeRepository;

	@Autowired
	public SocieteService(SocieteRepository societeRepository) {
		this.societeRepository = societeRepository;
	}
	
	public Societe save(Societe societe) {
		return societeRepository.save(societe);
	}

}
