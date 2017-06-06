package com.example.abd.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.abd.model.Artystaczlonek;

public interface ArtystaczlonekDao extends CrudRepository<Artystaczlonek, Integer> {
	Iterable<Artystaczlonek> findAll(Pageable pageable);
}