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

import com.social.dao.BateauRepository;
import com.social.entities.Bateau;

@RestController
@RequestMapping("bateau")
public class BateauController {

	@Autowired
	private BateauRepository bateauRepository;

	@GetMapping(value = "/listebateaux", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bateau> getAll() {
		List<Bateau> list = new ArrayList<>();
		Iterable<Bateau> bateaux = bateauRepository.findAll();

		bateaux.forEach(list::add);
		return list;
	}

	@CrossOrigin
	@RequestMapping(value = "/postbateau", method = RequestMethod.POST)
	public ResponseEntity<?> createBateau(@RequestBody Bateau newBateau) {

		return new ResponseEntity<Bateau>(bateauRepository.save(newBateau), HttpStatus.CREATED);
	}

	@GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bateau> findByLastId(@PathVariable int id) {

		List<Bateau> bateaux = bateauRepository.findById(id);
		return bateaux;
	}

}
