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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.ClientRepository;
import com.social.entities.Client;
import com.social.entities.User;
import com.social.util.CustomErrorType;

@RestController
@RequestMapping("fiche")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class FicheClientController {

	@Autowired
	private ClientRepository clientrepository;

	@GetMapping(value = "/ficheclients", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> getAll() {
		List<Client> list = new ArrayList<>();
		Iterable<Client> clients = clientrepository.findAll();

		clients.forEach(list::add);
		return list;
	}
	
	@RequestMapping(value = "/postficheclient", method = RequestMethod.POST)
	public ResponseEntity<?> createClient(@RequestBody Client newClient) {		

		return new ResponseEntity<Client>(clientrepository.save(newClient), HttpStatus.CREATED);
	}

	@GetMapping(value = "/findbynom/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> findByLastName(@PathVariable String nom) {

		List<Client> clients = clientrepository.findByNom(nom);
		return clients;
	}
	
	@DeleteMapping(value="/client/{id}")
	public boolean deleteClient(@PathVariable Long id) {
		clientrepository.delete(id);
		return true;
	}
	
	@PutMapping("/updateficheclient")
	public Client updateClient(Client client) {
		return clientrepository.save(client);
	}

}
