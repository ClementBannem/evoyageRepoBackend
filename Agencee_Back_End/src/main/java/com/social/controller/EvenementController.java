package com.social.controller;

import java.util.ArrayList;
import java.util.Collection;
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

import com.social.dao.EvenementRepository;
import com.social.entities.Evenement;
import com.social.services.EvenementServiceImpl;

@RestController
@RequestMapping("evenement")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EvenementController {

	@Autowired
	private EvenementRepository evensRepository;
	
	@Autowired
	private EvenementServiceImpl esi;

	@GetMapping(value = "/listeEvenement", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Evenement> getAll() {
		List<Evenement> list = new ArrayList<>();
		Iterable<Evenement> evens = evensRepository.findAll();

		evens.forEach(list::add);
		return list;
	}

	@RequestMapping(value = "/postevement", method = RequestMethod.POST)
	public ResponseEntity<?> createEvenement(@RequestBody Evenement newEvenement) {

		return new ResponseEntity<Evenement>(evensRepository.save(newEvenement), HttpStatus.CREATED);
	}

	@GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Evenement> findByLastId(@PathVariable int id) {

		List<Evenement> evens = evensRepository.findByIdE(id);
		return evens;
	}
	
	@GetMapping(value = "/evenements/{typeE}")
	public ResponseEntity<Evenement> findEvenementByTypeE(@PathVariable("typeE") String typeE) {
		//List<Evenement> event = esi.findByTypeE(typeE);
		Evenement event = esi.findByTypeE(typeE);
		System.out.println( "EVENEMENT TROUVE ----> " + event);
	    return new ResponseEntity<Evenement>(event,HttpStatus.FOUND);
	}

	@DeleteMapping(value = "/evenements/{id}")
	public boolean deleteEvenement(@PathVariable int id) {
		evensRepository.delete(id);
		return true;
	}

}
