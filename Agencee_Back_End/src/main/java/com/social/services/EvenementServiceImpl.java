package com.social.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.EvenementRepository;
import com.social.entities.Evenement;

@Service("EvenementService")
public class EvenementServiceImpl {
	

	private EvenementRepository evenementRepository;

	@Autowired
	public EvenementServiceImpl(EvenementRepository evenementRepository) {
		this.evenementRepository = evenementRepository;
	}
	
	public Evenement save(Evenement evens) {
		return evenementRepository.save(evens);
	}
	
//	public List<Evenement> findByTypeE (String typeE)
//	{
//		return evenementRepository.findByTypeE(typeE);
//	}
	public Evenement findByTypeE (String typeE)
	{
		return evenementRepository.findByTypeE(typeE);
	}
	

}
