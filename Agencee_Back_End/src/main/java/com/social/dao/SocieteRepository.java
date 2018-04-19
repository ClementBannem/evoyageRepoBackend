package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Societe;


public interface SocieteRepository extends JpaRepository<Societe, Integer>{
	
	List<Societe> findByCode(int code);

}
