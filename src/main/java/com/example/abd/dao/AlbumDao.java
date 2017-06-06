package com.example.abd.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.abd.model.Album;

public interface AlbumDao extends CrudRepository<Album, Integer> {
	Iterable<Album> findAll(Pageable pageable);
}