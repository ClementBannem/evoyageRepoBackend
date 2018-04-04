package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.AutocarRepository;
import com.social.entities.AutoCar;



@Service("AutocarService")
public class AutocarService {
	
	private AutocarRepository autocarRepository;

	@Autowired
	public AutocarService(AutocarRepository autocarRepository) {
		this.autocarRepository = autocarRepository;
	}
	
	public AutoCar save(AutoCar autocar) {
		return autocarRepository.save(autocar);
	}
	

}
