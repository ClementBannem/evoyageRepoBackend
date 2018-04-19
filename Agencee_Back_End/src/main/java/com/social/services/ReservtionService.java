package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.ReservationRepository;
import com.social.entities.Reservation;



@Service("reservtionService")
public class ReservtionService {
	private ReservationRepository reservationRepository;

	@Autowired
	public ReservtionService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	public Reservation save(Reservation res) {
		return reservationRepository.save(res);
	}
}
