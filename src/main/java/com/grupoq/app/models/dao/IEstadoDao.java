package com.grupoq.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.grupoq.app.models.entity.EstadoC;

public interface IEstadoDao extends CrudRepository<EstadoC, Long> {
	public List<EstadoC> findAllByOrderByEstadoAsc();

}
