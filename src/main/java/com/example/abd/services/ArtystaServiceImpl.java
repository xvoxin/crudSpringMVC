package com.example.abd.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.abd.dao.ArtystaDao;
import com.example.abd.model.Album;
import com.example.abd.model.Artysta;


@Service("artystaService")
@Transactional
public class ArtystaServiceImpl implements ArtystaService{

	@Autowired
	private ArtystaDao artystaDao;
	
	@Override
	public Iterable<Artysta> findAll() {
		return artystaDao.findAll();
	}
	@Override
	public Iterable<Artysta> findAll(int pageNr) {
		return artystaDao.findAll(pagination(pageNr));
	}
	
	private Pageable pagination(int pageNr){
		return new PageRequest(pageNr, 5, Direction.ASC, "nazwa"); //tutaj rowniez sortuje rekordy rosnaco po nazwie
	}
	
	@Override
	public void save(Artysta ac) {
		artystaDao.save(ac);		
	}
	
	public void delete(Artysta artysta) {
		artystaDao.delete(artysta);
	}

	@Override
	public Artysta findOne(int id) {
		return artystaDao.findOne(id);
	}

}