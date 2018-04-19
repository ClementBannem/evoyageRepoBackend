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

import com.social.dao.SocieteRepository;
import com.social.entities.Societe;



@RestController
@RequestMapping("societe")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class SocieteController {

	@Autowired
    private SocieteRepository societeRepository;
	
    @GetMapping(value = "/listeSocietes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Societe> getAll() {
		List<Societe> list = new ArrayList<>();
		Iterable<Societe> societe = societeRepository.findAll();

		societe.forEach(list::add);
		return list;
	}
    
	@RequestMapping(value = "/postSociete", method = RequestMethod.POST)
	public ResponseEntity<?> createSociete(@RequestBody Societe newSociete) {		

		return new ResponseEntity<Societe>(societeRepository.save(newSociete), HttpStatus.CREATED);
	}

    
    @GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Societe> findByLastId(@PathVariable int id) {

		List<Societe> offre = societeRepository.findByCode(id);
		return offre;
	}
    
    @DeleteMapping(value="/societes/{id}")
 	public boolean deleteSociete(@PathVariable int id) {
    	societeRepository.delete(id);
 		return true;
 	}
}
