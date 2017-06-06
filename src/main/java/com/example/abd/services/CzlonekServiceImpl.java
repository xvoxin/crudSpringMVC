package com.example.abd.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.abd.dao.CzlonekDao;
import com.example.abd.model.Album;
import com.example.abd.model.Czlonek;

@Service("czlonekService")
@Transactional
public class CzlonekServiceImpl implements CzlonekService{

	@Autowired
	private CzlonekDao czlonekDao;
	
	@Override
	public Iterable<Czlonek> findAll() {
		return czlonekDao.findAll();
	}
	@Override
	public Iterable<Czlonek> findAll(int pageNr) {
		return czlonekDao.findAll(pagination(pageNr));
	}
	
	private Pageable pagination(int pageNr){
		return new PageRequest(pageNr, 5, Direction.ASC, "imie"); //tutaj rowniez sortuje rekordy rosnaco po nazwie
	}
	
	@Override
	public void save(Czlonek czlonek) {
		czlonekDao.save(czlonek);		
	}
	
	public void delete(Czlonek czlonek) {
		czlonekDao.delete(czlonek);
	}

	@Override
	public Czlonek findOne(int id) {
		return czlonekDao.findOne(id);
	}

}