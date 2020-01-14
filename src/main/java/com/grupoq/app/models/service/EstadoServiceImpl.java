package com.grupoq.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupoq.app.models.dao.IEstadoDao;
import com.grupoq.app.models.entity.EstadoC;

@Service
public class EstadoServiceImpl implements IEstadoService {
	
	@Autowired
	public IEstadoDao estadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<EstadoC> findAllByOrderByEstadoAsc() {
		return estadoDao.findAllByOrderByEstadoAsc();
	}

}
