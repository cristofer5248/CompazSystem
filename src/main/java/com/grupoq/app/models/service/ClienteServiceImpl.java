package com.grupoq.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grupoq.app.models.dao.IMiebrostDao;
import com.grupoq.app.models.entity.Miembro;


@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IMiebrostDao clienteDao;

	
	@Override
	@Transactional(readOnly = true)
	public List<Miembro> findAll() {
		// TODO Auto-generated method stub
		return (List<Miembro>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Miembro cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Miembro findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Miembro> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	public Miembro fetchByIdWithTallerWithFactura(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFactura(Long id) {
		// TODO Auto-generated method stub
		
	}

	

	
}
