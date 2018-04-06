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

import com.social.dao.OffreRepository;
import com.social.entities.Offre;

@RestController
@RequestMapping("offre")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class OffreController {
	
	@Autowired
    private OffreRepository offreRepository;
	
    @GetMapping(value = "/listeOffre", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Offre> getAll() {
		List<Offre> list = new ArrayList<>();
		Iterable<Offre> offre = offreRepository.findAll();

		offre.forEach(list::add);
		return list;
	}
    
	@RequestMapping(value = "/postOffre", method = RequestMethod.POST)
	public ResponseEntity<?> createOffre(@RequestBody Offre newOffre) {		

		return new ResponseEntity<Offre>(offreRepository.save(newOffre), HttpStatus.CREATED);
	}

    
    @GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Offre> findByLastId(@PathVariable int id) {

		List<Offre> offre = offreRepository.findByIdO(id);
		return offre;
	}


}
