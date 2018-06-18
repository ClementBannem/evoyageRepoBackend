package com.social.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.ClientRepository;
import com.social.entities.Client;
import com.social.security.ActiveUserStore;
import com.social.services.ClientService;

@RestController
@RequestMapping("fiche")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FicheClientController extends BaseController {

	@Autowired
	private ClientRepository clientrepository;

	@Autowired
	private ClientService clientservices;

	@Autowired
	ActiveUserStore activeUserStore;
	
	public static final Logger logger = LoggerFactory.getLogger(FicheClientController.class);

	// @Autowired
	// private MySessionInfo mySessionInfo;

	@GetMapping(value = "/ficheclients", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> getAll() {
		Iterable<Client> clients = clientrepository.findAll();
		List<Client> list = new ArrayList<>();
		clients.forEach(list::add);
		return list;
	}

	@RequestMapping(value = "/postficheclient", method = RequestMethod.POST)
	public ResponseEntity<Client> createClient(@RequestBody Client newClient,Authentication authentication) {
		//String user="";
//		for(GrantedAuthority authority : authentication.getAuthorities()) {
//			String role = authority.getAuthority();
//			System.out.println("L'UTILISATEUR CONNECTE EST =" + authentication.getName() + role + " ...");
//		}
		// Object id =
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// Object id = principal.getName();

		// User user = (User)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// Long name = user.getId(); // Ici le probleme est le Cast

		// String name = mySessionInfo.getCurrentUser().getUsername();

		// System.out.println("UTILISATEUR QUI A AJOUTE EST --------------------->" +
		// name);

		//String currentId = currentUser.getFullName();
		//System.out.println("L'ID du user connecté est=" + currentId + "...");
		//logger.info("L'UTILISATEUR CONNECTE EST --> " + principal);
		//System.out.println("L'UTILISATEUR CONNECTE EST =" + principal + " ...");
		// newClient.setUser(currentId);
		return new ResponseEntity<Client>(clientservices.save(newClient), HttpStatus.CREATED);
	}

	// @RequestMapping(value = "/postficheclient/{id}", method = RequestMethod.POST)
	// public ResponseEntity<?> createClient(@PathVariable("id") Long
	// id,@RequestBody Client newClient) {
	// System.out.println("Ajoute par USer with ID=" + id + "...");
	// // newClient.setUser(user);
	// Client clientData = clientrepository.findOne(id);
	// if (clientData == null) {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// clientData.setUser(newClient.getUser());
	// return new ResponseEntity<Client>(clientservices.save(newClient),
	// HttpStatus.CREATED);
	// }

	@GetMapping(value = "/findbynom/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> findByLastName(@PathVariable String nom) {

		List<Client> clients = clientrepository.findByNom(nom);
		return clients;
	}

	@DeleteMapping(value = "/client/{id}")
	public boolean deleteClient(@PathVariable Long id) {
		clientrepository.delete(id);
		return true;
	}

	@PutMapping(value = "/updateficheclient/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
		System.out.println("Mettre a jour le client avec l'ID = " + id + "...");

		Client clientData = clientrepository.findOne(id);
		if (clientData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clientData.setNom(client.getNom());
		clientData.setPrenom(client.getPrenom());
		clientData.setEmail(client.getEmail());
		clientData.setPortable(client.getPortable());
		clientData.setDomicile(client.getDomicile());
		clientData.setSexe(client.getSexe());
		clientData.setDate_naissance(client.getDate_naissance());
		clientData.setAdresse(client.getAdresse());
		clientData.setCode_postale(client.getCode_postale());
		clientData.setVille(client.getVille());
		clientData.setPays(client.getPays());
		clientData.setNumeroCB(client.getNumeroCB());
		clientData.setExpirationCB(client.getExpirationCB());

		Client clientmaj = clientrepository.save(clientData);
		return new ResponseEntity<>(clientmaj, HttpStatus.OK);
	}

}
