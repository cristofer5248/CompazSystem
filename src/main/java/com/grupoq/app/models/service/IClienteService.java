package com.grupoq.app.models.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.grupoq.app.models.entity.Miembro;




public interface IClienteService {

	public List<Miembro> findAll();
	
	public Page<Miembro> findAll(Pageable pageable);

	public void save(Miembro cliente);
	
	public Miembro findOne(Long id);
	
	public Miembro fetchByIdWithTallerWithFactura(Long id);
	
	public void delete(Long id);		
	
	
	public void deleteFactura(Long id);
	
	
}