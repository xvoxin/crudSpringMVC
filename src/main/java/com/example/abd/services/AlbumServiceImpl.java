package com.example.abd.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.abd.dao.AlbumDao;
import com.example.abd.model.Album;


@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumDao albumDao;
	
	@Override
	public Iterable<Album> findAll(int pageNr) {
		return albumDao.findAll(pagination(pageNr));
	}
	
	public Iterable<Album> findAll() {
		return albumDao.findAll();
	}
	
	private Pageable pagination(int pageNr){
		return new PageRequest(pageNr, 5, Direction.ASC, "nazwa"); //tutaj rowniez sortuje rekordy rosnaco po nazwie
	}
	
	@Override
	public void save(Album album) {
		albumDao.save(album);		
	}

	@Override
	public void delete(Album album) {
		albumDao.delete(album);
	}

	@Override
	public Album findOne(int id) {
		return albumDao.findOne(id);
	}


}
