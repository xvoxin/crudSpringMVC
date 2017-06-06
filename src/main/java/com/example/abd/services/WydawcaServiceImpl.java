package com.example.abd.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.abd.dao.WydawcaDao;
import com.example.abd.model.Album;
import com.example.abd.model.Wydawca;


@Service("wydawcaService")
@Transactional
public class WydawcaServiceImpl implements WydawcaService {

	@Autowired
	private WydawcaDao wydawcaDao;
	
	@Override
	public Iterable<Wydawca> findAll() {
		return wydawcaDao.findAll();
	}
	@Override
	public Iterable<Wydawca> findAll(int pageNr) {
		return wydawcaDao.findAll(pagination(pageNr));
	}
	
	private Pageable pagination(int pageNr){
		return new PageRequest(pageNr, 5, Direction.ASC, "nazwa"); //tutaj rowniez sortuje rekordy rosnaco po nazwie
	}
	@Override
	public void save(Wydawca ac) {
		wydawcaDao.save(ac);		
	}
	public void delete(Wydawca wydawca) {
		wydawcaDao.delete(wydawca);
	}

	@Override
	public Wydawca findOne(int id) {
		return wydawcaDao.findOne(id);
	}

}