package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.AutocarRepository;

import com.social.entities.AutoCar;

@RestController
@RequestMapping("autocar")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class AutocarController {
	
	@Autowired
    private AutocarRepository autocarRepository;
	
    @GetMapping(value = "/listeTransportAutocar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AutoCar> getAll() {
		List<AutoCar> list = new ArrayList<>();
		Iterable<AutoCar> autocar = autocarRepository.findAll();

		autocar.forEach(list::add);
		return list;
	}
    
	@RequestMapping(value = "/postTransportAutocar", method = RequestMethod.POST)
	public ResponseEntity<?> createAutoCar(@RequestBody AutoCar newAutoCar) {		

		return new ResponseEntity<AutoCar>(autocarRepository.save(newAutoCar), HttpStatus.CREATED);
	}
    
    @GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AutoCar> findByLastId(@PathVariable int id) {

		List<AutoCar> autocar = autocarRepository.findById(id);
		return autocar;
	}
    
    @DeleteMapping(value = "/autocars/{id}")
	public boolean deleteAutocar(@PathVariable int id) {
    	autocarRepository.delete(id);
		return true;
	}

}
