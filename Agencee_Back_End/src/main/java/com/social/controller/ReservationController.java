package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.converter.VoyageToReservableVoyageResponseConverter;
import com.social.dao.PageableVoyageRepository;
import com.social.dao.ReservationRepository;
import com.social.dao.VoyageRepository;
import com.social.entities.Reservation;
import com.social.entities.Voyage;
import com.social.request.ReservationRequest;
import com.social.response.ReservableVoyageResponse;
import com.social.response.ReservationResponse;
import com.social.services.ReservationService;

@RestController
//@RequestMapping("reservation")
@RequestMapping(ResourceConstants.VOYAGE_RESERVATION_V1)
@CrossOrigin(origins = "http://localhost:4201", allowedHeaders = "*")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	ReservationService reservationservices;

	@Autowired
	VoyageRepository voyageRepository;

	@Autowired
	ConversionService conversionService;
	
	@Autowired
	PageableVoyageRepository pageableVoyageRepository;

//	@GetMapping(value = "/listeResevation", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Reservation> getAll() {
//		List<Reservation> list = new ArrayList<>();
//		Iterable<Reservation> offre = reservationRepository.findAll();
//
//		offre.forEach(list::add);
//		return list;
//	}
	@GetMapping(value = "/listeResevation", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<ReservableVoyageResponse> getAvailableVoyages(Pageable pageable) {
		Page<Voyage> voyageList = pageableVoyageRepository.findAll(pageable);
		return voyageList.map(new VoyageToReservableVoyageResponseConverter());
	}
	
	@RequestMapping(path = "/{voyageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Voyage> getVoyageId(@PathVariable Long voyageId){
		Voyage voyage = voyageRepository.findById(voyageId);
		return new ResponseEntity<>(voyage, HttpStatus.OK);
		
	}

	// @PutMapping(value = "/postReservation/{id}")
	// public ResponseEntity<Reservation> createReservation(@PathVariable("id") int
	// id, @RequestBody Reservation newReservation) {
	// Reservation reservData = reservationRepository.findOneVoyageBy(id);
	// if (reservData == null) {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// reservData.setVoyage(newReservation.getVoyage());
	//
	// Reservation reservDone = reservationRepository.save(reservData);
	// return new ResponseEntity<>(reservDone, HttpStatus.OK);
	//
	// //return new
	// ResponseEntity<Reservation>(reservationservices.save(newReservation),
	// HttpStatus.CREATED);
	// }

	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(
			@RequestBody ReservationRequest reservationRequest) {

		Reservation reservation = conversionService.convert(reservationRequest, Reservation.class);
		reservationRepository.save(reservation);
		Voyage voyage = voyageRepository.findById(reservationRequest.getVoyageId());
		
		voyage.addReservation(reservation);
		voyageRepository.save(voyage);
		reservation.setVoyage(voyage);
		
		ReservationResponse reservationResponse = conversionService.convert(reservation, ReservationResponse.class);

		return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);

	}

	@DeleteMapping(value = "/resev/{id}")
	public boolean deleteClient(@PathVariable Long id) {
		reservationRepository.delete(id);
		return true;
	}

}
