package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Avion;


public interface AvionRepository extends JpaRepository<Avion, Integer> {
	List<Avion> findById(int id);

}
