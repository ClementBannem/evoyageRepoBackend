package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.AvionRepository;
import com.social.entities.Avion;

@RestController
@RequestMapping("avion")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AvionController {

	@Autowired
	private AvionRepository avionRepository;

	@GetMapping(value = "/listeTransportAvion", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Avion> getAll() {
		List<Avion> list = new ArrayList<>();
		Iterable<Avion> avion = avionRepository.findAll();

		avion.forEach(list::add);
		return list;
	}

	@RequestMapping(value = "/postTransportAvion", method = RequestMethod.POST)
	public ResponseEntity<?> createAvion(@RequestBody Avion newAvion) {

		return new ResponseEntity<Avion>(avionRepository.save(newAvion), HttpStatus.CREATED);
	}

	@GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Avion> findByLastId(@PathVariable int id) {

		List<Avion> avion = avionRepository.findById(id);
		return avion;
	}

}
