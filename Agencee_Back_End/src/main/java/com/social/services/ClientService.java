package com.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.ClientRepository;
import com.social.entities.Client;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientrepository;
	
	public Client save(Client client) {
		return clientrepository.saveAndFlush(client);
	}
	
	public Client update(Client client) {
		return clientrepository.save(client);
	}
	
	public Client find(String nom) {
		return clientrepository.findOneByNom(nom);
	}
	
	public Client find(int id) {
		return clientrepository.findOne((long) id);
	}

}
