package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.ReservationRepository;
import com.social.entities.Reservation;
import com.social.services.ReservationService;

@RestController
@RequestMapping("reservation")
@CrossOrigin(origins = "http://localhost:4201", allowedHeaders = "*")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private ReservationService reservationservices;

	@GetMapping(value = "/listeResevation", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reservation> getAll() {
		List<Reservation> list = new ArrayList<>();
		Iterable<Reservation> offre = reservationRepository.findAll();

		offre.forEach(list::add);
		return list;
	}

	@PutMapping(value = "/postReservation/{id}")
	public ResponseEntity<Reservation> createReservation(@PathVariable("id") int id, @RequestBody Reservation newReservation) {
		Reservation reservData = reservationRepository.findOneVoyageBy(id);
		if (reservData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		reservData.setVoyage(newReservation.getVoyage());
		
		Reservation reservDone = reservationRepository.save(reservData);
		return new ResponseEntity<>(reservDone, HttpStatus.OK);

		//return new ResponseEntity<Reservation>(reservationservices.save(newReservation), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/resev/{id}")
	public boolean deleteClient(@PathVariable int id) {
		reservationRepository.delete(id);
		return true;
	}

}
