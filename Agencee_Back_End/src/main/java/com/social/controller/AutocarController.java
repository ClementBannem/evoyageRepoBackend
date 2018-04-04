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

import com.social.dao.AutocarRepository;

import com.social.entities.AutoCar;

@Controller
@RequestMapping("autocar")
public class AutocarController {
	
	@Autowired
    private AutocarRepository autocarRepository;
	
    @GetMapping(value = "/listetransport", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AutoCar> getAll() {
		List<AutoCar> list = new ArrayList<>();
		Iterable<AutoCar> autocar = autocarRepository.findAll();

		autocar.forEach(list::add);
		return list;
	}
    
	@CrossOrigin
	@RequestMapping(value = "/posttransport", method = RequestMethod.POST)
	public ResponseEntity<?> createAutoCar(@RequestBody AutoCar newAutoCar) {		

		return new ResponseEntity<AutoCar>(autocarRepository.save(newAutoCar), HttpStatus.CREATED);
	}

    
    @GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AutoCar> findByLastId(@PathVariable int id) {

		List<AutoCar> autocar = autocarRepository.findById(id);
		return autocar;
	}

}
