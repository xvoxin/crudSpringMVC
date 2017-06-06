package com.example.abd.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.abd.model.Artysta;

public interface ArtystaDao extends CrudRepository<Artysta, Integer> {
	Iterable<Artysta> findAll(Pageable pageable);
}