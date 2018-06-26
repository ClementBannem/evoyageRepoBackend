package com.social.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Voyage;

public interface VoyageRepository extends JpaRepository<Voyage, Long>{
	
	Voyage findById(Long id);

}
