package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.AvionRepository;
import com.social.entities.Avion;



@Service("AvionService")
public class AvionService {
	
	private AvionRepository avionRepository;

	@Autowired
	public AvionService(AvionRepository avionRepository) {
		this.avionRepository = avionRepository;
	}
	
	public Avion save(Avion avion) {
		return avionRepository.save(avion);
	}
	

}
