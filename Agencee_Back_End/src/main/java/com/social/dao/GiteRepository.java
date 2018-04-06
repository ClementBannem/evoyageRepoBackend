package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Gite;

public interface GiteRepository extends JpaRepository<Gite, Integer> {
	List<Gite> findByLibelle(String Libelle);

	//Gite findOnebyLibelle(String libelle);

}
