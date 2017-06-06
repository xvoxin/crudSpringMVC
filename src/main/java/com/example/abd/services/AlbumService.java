package com.example.abd.services;

import com.example.abd.model.Album;

public interface AlbumService {
	public Iterable<Album> findAll(int pageNr);
	public void delete(Album album);
	public void save(Album album);
	public Album findOne(int id);
}
