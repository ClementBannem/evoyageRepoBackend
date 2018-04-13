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

import com.social.dao.GiteRepository;
import com.social.entities.Gite;

@RestController
@RequestMapping("gite")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class GiteController {

	@Autowired
	private GiteRepository giteRepo;

	@GetMapping(value = "/listeHebergementGite", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Gite> getAll() {
		List<Gite> list = new ArrayList<>();
		Iterable<Gite> gite = giteRepo.findAll();

		gite.forEach(list::add);
		return list;
	}

	@RequestMapping(value = "/postHebergementGite", method = RequestMethod.POST)
	public ResponseEntity<?> createGite(@RequestBody Gite newGite) {

		return new ResponseEntity<Gite>(giteRepo.save(newGite), HttpStatus.CREATED);
	}

	@GetMapping(value = "/findbylibelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Gite> findByLibelle(@PathVariable String libelle) {

		List<Gite> gite = giteRepo.findByLibelle(libelle);
		return gite;
	}

	@DeleteMapping(value = "/gites/{id}")
	public boolean deleteGite(@PathVariable int id) {
		giteRepo.delete(id);
		return true;
	}
}
