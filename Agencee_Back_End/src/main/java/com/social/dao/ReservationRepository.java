package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Reservation;
import com.social.entities.Voyage;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	Reservation findOneVoyageBy(int id);

}
