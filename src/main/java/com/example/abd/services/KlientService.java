package com.example.abd.services;

import com.example.abd.model.Klient;

public interface KlientService {
	public Iterable<Klient> findAll(int pageNr);
	public void save(Klient klient);
	Klient findOne(int id);
}
