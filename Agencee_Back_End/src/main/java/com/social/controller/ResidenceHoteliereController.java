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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.ResidenceHoteliereRepository;
import com.social.entities.Residence_Hoteliere;

@RestController
@RequestMapping("residenceHoteliere")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ResidenceHoteliereController {

	@Autowired
	private ResidenceHoteliereRepository rhRepo;

	@GetMapping(value = "/listeHebergementResidenceHoteliere", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Residence_Hoteliere> getAll() {
		List<Residence_Hoteliere> list = new ArrayList<>();
		Iterable<Residence_Hoteliere> resHot = rhRepo.findAll();

		resHot.forEach(list::add);
		return list;
	}

	@RequestMapping(value = "/postHebergementResidenceHoteliere", method = RequestMethod.POST)
	public ResponseEntity<?> createResidenceHoteliere(@RequestBody Residence_Hoteliere newResidenceHoteliere) {

		return new ResponseEntity<Residence_Hoteliere>(rhRepo.save(newResidenceHoteliere), HttpStatus.CREATED);
	}

	@GetMapping(value = "/findbylibelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Residence_Hoteliere> findByLibelle(@PathVariable String libelle) {

		List<Residence_Hoteliere> resHot = rhRepo.findByLibelle(libelle);
		return resHot;
	}

	@DeleteMapping(value = "/residences/{id}")
	public boolean deleteResidence(@PathVariable int id) {
		rhRepo.delete(id);
		return true;
	}
}
