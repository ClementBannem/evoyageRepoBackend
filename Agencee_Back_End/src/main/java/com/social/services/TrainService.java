package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.TrainRepository;
import com.social.entities.Train;


@Service("TrainService")
public class TrainService {
	
	private TrainRepository trainRepository;

	@Autowired
	public TrainService(TrainRepository trainRepository) {
		this.trainRepository = trainRepository;
	}
	
	public Train save(Train train) {
		return trainRepository.save(train);
	}
	

}
