package com.example.abd.services;

import com.example.abd.model.Wydawca;

public interface WydawcaService {
	public Iterable<Wydawca> findAll();
	public Iterable<Wydawca> findAll(int pageNr);
	public void save(Wydawca wydawca);
	Wydawca findOne(int id);
}
