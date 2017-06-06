package com.example.abd.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.abd.model.Klient;

public interface KlientDao extends CrudRepository<Klient, Integer> {
	Iterable<Klient> findAll(Pageable pageable);
}