package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

	List<Evenement> findByIdE(int idE);
}
