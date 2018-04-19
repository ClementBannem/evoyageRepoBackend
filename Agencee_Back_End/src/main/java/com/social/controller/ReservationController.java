package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.social.dao.ReservationRepository;
import com.social.entities.Reservation;


@RestController
@RequestMapping("reservation")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ReservationController {

	@Autowired
    private ReservationRepository reservationRepository;
	
    @GetMapping(value = "/listeResevation", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reservation> getAll() {
		List<Reservation> list = new ArrayList<>();
		Iterable<Reservation> offre = reservationRepository.findAll();

		offre.forEach(list::add);
		return list;
	}
    
	@RequestMapping(value = "/postReservation", method = RequestMethod.POST)
	public ResponseEntity<?> createOffre(@RequestBody Reservation newOffre) {		

		return new ResponseEntity<Reservation>(reservationRepository.save(newOffre), HttpStatus.CREATED);
	}

    
    @GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reservation> findByLastId(@PathVariable int id) {

		List<Reservation> offre = reservationRepository.findByIdR(id);
		return offre;
	}
    
    @DeleteMapping(value="/resev/{id}")
 	public boolean deleteClient(@PathVariable int id) {
    	reservationRepository.delete(id);
 		return true;
 	}

}
