package com.example.abd.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.abd.model.Czlonek;

public interface CzlonekDao extends CrudRepository<Czlonek, Integer> {
	Iterable<Czlonek> findAll(Pageable pageable);
}