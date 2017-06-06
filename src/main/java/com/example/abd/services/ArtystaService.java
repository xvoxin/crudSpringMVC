package com.example.abd.services;

import com.example.abd.model.Artysta;

public interface ArtystaService {
	public Iterable<Artysta> findAll();
	public Iterable<Artysta> findAll(int pageNr);
	public void save(Artysta artysta);
	Artysta findOne(int id);
}
