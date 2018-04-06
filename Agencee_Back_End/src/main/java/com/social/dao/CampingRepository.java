package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Camping;

public interface CampingRepository extends JpaRepository<Camping, Integer> {
	List<Camping> findByLibelle(String Libelle);

//	Camping findOnebyLibelle(String libelle);

}
