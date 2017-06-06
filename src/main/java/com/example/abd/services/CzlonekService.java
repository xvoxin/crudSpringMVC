package com.example.abd.services;

import com.example.abd.model.Czlonek;

public interface CzlonekService {
	public Iterable<Czlonek> findAll();
	public Iterable<Czlonek> findAll(int pageNr);
	public void save(Czlonek czlonek);
	Czlonek findOne(int id);
}

