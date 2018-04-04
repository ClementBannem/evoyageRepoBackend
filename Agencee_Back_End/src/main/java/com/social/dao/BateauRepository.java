package com.social.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Bateau;


public interface BateauRepository extends JpaRepository<Bateau, Integer> {
	List<Bateau> findById(int id);

}
