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

import com.social.dao.AdherantRepository;
import com.social.entities.Adherant;



@RestController
@RequestMapping("adherant")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class AdherantController {
	@Autowired
    private AdherantRepository adherantRepository;
	
    @GetMapping(value = "/listeAdherants", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Adherant> getAll() {
		List<Adherant> list = new ArrayList<>();
		Iterable<Adherant> adherant = adherantRepository.findAll();

		adherant.forEach(list::add);
		return list;
	}
    
	@RequestMapping(value = "/postAdherant", method = RequestMethod.POST)
	public ResponseEntity<?> createAdherant(@RequestBody Adherant newAdherant) {		

		return new ResponseEntity<Adherant>(adherantRepository.save(newAdherant), HttpStatus.CREATED);
	}

    
    @GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Adherant> findByLastId(@PathVariable long id) {

		List<Adherant> offre = adherantRepository.findByIdA(id);
		return offre;
	}
    
    @DeleteMapping(value="/adherants/{id}")
 	public boolean deleteAdherant(@PathVariable long id) {
    	adherantRepository.delete(id);
 		return true;
 	}

}
