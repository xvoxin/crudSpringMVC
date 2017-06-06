package com.example.abd.services;

import com.example.abd.model.Artystaczlonek;

public interface ArtystaczlonekService {
	public Iterable<Artystaczlonek> findAll(int pageNr);
	public void save(Artystaczlonek ac);
	Artystaczlonek findOne(int id);
}
