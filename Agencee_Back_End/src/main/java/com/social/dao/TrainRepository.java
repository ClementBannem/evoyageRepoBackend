package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.entities.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {
	List<Train> findById(int id);

}
