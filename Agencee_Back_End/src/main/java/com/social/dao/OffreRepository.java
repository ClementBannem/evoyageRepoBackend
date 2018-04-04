package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Offre;

public interface OffreRepository extends JpaRepository<Offre, Integer>{
	
	List<Offre> findByIdO(int idO);

}
