package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Client;
import com.social.entities.User;

public interface ClientRepository extends JpaRepository<Client, Long>{
	List<Client> findByNom(String Nom);
	Client findOneByNom(String nom);
	
}
