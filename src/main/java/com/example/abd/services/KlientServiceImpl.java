package com.example.abd.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.abd.dao.KlientDao;
import com.example.abd.model.Album;
import com.example.abd.model.Klient;


@Service("klientService")
@Transactional
public class KlientServiceImpl implements KlientService{

	@Autowired
	private KlientDao klientDao;
	
	@Override
	public Iterable<Klient> findAll(int pageNr) {
		return klientDao.findAll(pagination(pageNr));
	}
	public Iterable<Klient> findAll() {
		return klientDao.findAll();
	}
	
	private Pageable pagination(int pageNr){
		return new PageRequest(pageNr, 5, Direction.ASC, "imie"); //tutaj rowniez sortuje rekordy rosnaco po nazwie
	}
	
	@Override
	public void save(Klient ac) {
		klientDao.save(ac);		
	}
	public void delete(Klient klient) {
		klientDao.delete(klient);
	}

	@Override
	public Klient findOne(int id) {
		return klientDao.findOne(id);
	}

}