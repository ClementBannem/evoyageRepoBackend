package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Adherant;

public interface AdherantRepository extends JpaRepository<Adherant, Long> {
	
	List<Adherant> findByIdA(long idA);

}
