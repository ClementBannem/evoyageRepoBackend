package com.social.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.social.entities.Voyage;

public interface PageableVoyageRepository extends PagingAndSortingRepository<Voyage, Long>{
	Page<Voyage> findById(Long id, Pageable page);

}
