package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Residence_Hoteliere;

public interface ResidenceHoteliereRepository extends JpaRepository<Residence_Hoteliere, Integer> {
	List<Residence_Hoteliere> findByLibelle(String Libelle);

	//Residence_Hoteliere findOnebyLibelle(String libelle);

}
