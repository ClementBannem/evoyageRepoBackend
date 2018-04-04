package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.AutoCar;


public interface AutocarRepository extends JpaRepository<AutoCar, Integer> {
	List<AutoCar> findById(int id);

}
