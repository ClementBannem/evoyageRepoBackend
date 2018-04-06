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

import com.social.dao.TrainRepository;
import com.social.entities.Train;


@RestController
@RequestMapping("train")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class TrainController {
 
	@Autowired
    private TrainRepository trainRepository;
	
    @GetMapping(value = "/listeTransportTrain", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Train> getAll() {
		List<Train> list = new ArrayList<>();
		Iterable<Train> train = trainRepository.findAll();

		train.forEach(list::add);
		return list;
	}
    
	@RequestMapping(value = "/postTransportTrain", method = RequestMethod.POST)
	public ResponseEntity<?> createTrain(@RequestBody Train newTrain) {		

		return new ResponseEntity<Train>(trainRepository.save(newTrain), HttpStatus.CREATED);
	}

    
    @GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Train> findByLastId(@PathVariable int id) {

		List<Train> train = trainRepository.findById(id);
		return train;
	}
}
