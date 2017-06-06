package com.example.abd.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.abd.dao.ArtystaczlonekDao;
import com.example.abd.model.Artystaczlonek;

@Service("artystaczlonekService")
@Transactional
public class ArtystaczlonekServiceImpl implements ArtystaczlonekService{

	@Autowired
	private ArtystaczlonekDao artystaczlonekDao;
	
	@Override
	public Iterable<Artystaczlonek> findAll(int pageNr) {
		return artystaczlonekDao.findAll(pagination(pageNr));
	}
	public Iterable<Artystaczlonek> findAll() {
		return artystaczlonekDao.findAll();
	}
	
	private Pageable pagination(int pageNr){
		return new PageRequest(pageNr, 5, Direction.ASC, "artystacz"); //tutaj rowniez sortuje rekordy rosnaco po nazwie
	}
	
	@Override
	public void save(Artystaczlonek ac) {
		artystaczlonekDao.save(ac);		
	}
	
	public void delete(Artystaczlonek ac) {
		artystaczlonekDao.delete(ac);
	}

	@Override
	public Artystaczlonek findOne(int id) {
		return artystaczlonekDao.findOne(id);
	}

}