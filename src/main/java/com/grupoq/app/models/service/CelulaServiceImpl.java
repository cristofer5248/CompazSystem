package com.grupoq.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupoq.app.models.dao.ICelulaDao;
import com.grupoq.app.models.entity.Celula;

@Service
public class CelulaServiceImpl implements ICelulaService {
	
	@Autowired
	private ICelulaDao celulaDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Celula> findAll() {
		return (List<Celula>) celulaDao.findAll();
		
	}


	@Override
	@Transactional(readOnly = true)
	public List<Celula> findAllByOrderByNombrecAsc() {
		// TODO Auto-generated method stub
		return (List<Celula>) celulaDao.findAllByOrderByNombrecAsc();
	}

}
