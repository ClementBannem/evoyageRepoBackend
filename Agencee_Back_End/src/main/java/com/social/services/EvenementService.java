package com.social.services;

import com.social.entities.Evenement;

public interface EvenementService {
	
	Evenement save(Evenement evenement);
	
	Evenement findByTypeE(String typeE);

}
