package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.ReservationRepository;
import com.social.entities.Reservation;



//@Service("reservationService")
@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;

//	@Autowired
//	public ReservationService(ReservationRepository reservationRepository) {
//		this.reservationRepository = reservationRepository;
//	}
	
	public Reservation save(Reservation res) {
		return reservationRepository.save(res);
	}
}
