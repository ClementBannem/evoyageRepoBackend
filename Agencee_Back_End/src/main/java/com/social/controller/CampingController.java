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

import com.social.dao.CampingRepository;
import com.social.entities.Camping;

@RestController
@RequestMapping("camping")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CampingController {

	@Autowired
	private CampingRepository camR;

	@GetMapping(value = "/listeHebergementCamping", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Camping> getAll() {
		List<Camping> list = new ArrayList<>();
		Iterable<Camping> camping = camR.findAll();

		camping.forEach(list::add);
		return list;
	}

	@RequestMapping(value = "/postHebergementCamping", method = RequestMethod.POST)
	public ResponseEntity<?> createCamping(@RequestBody Camping newCamping) {

		return new ResponseEntity<Camping>(camR.save(newCamping), HttpStatus.CREATED);
	}

	@GetMapping(value = "/findbylibelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Camping> findByLibelle(@PathVariable String libelle) {

		List<Camping> camping = camR.findByLibelle(libelle);
		return camping;
	}

	@DeleteMapping(value = "/campings/{id}")
	public boolean deleteCamping(@PathVariable int id) {
		camR.delete(id);
		return true;
	}

}
