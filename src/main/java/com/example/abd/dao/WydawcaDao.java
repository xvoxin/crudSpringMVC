package com.example.abd.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.abd.model.Wydawca;

public interface WydawcaDao extends CrudRepository<Wydawca, Integer> {
	Iterable<Wydawca> findAll(Pageable pageable);
}
