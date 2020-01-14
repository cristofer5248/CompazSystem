package com.grupoq.app.models.service;

import java.util.List;

import com.grupoq.app.models.entity.Celula;

public interface ICelulaService {

	public List<Celula> findAll();
	
	public List<Celula> findAllByOrderByNombrecAsc();
}
