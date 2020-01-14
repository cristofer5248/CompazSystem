package com.grupoq.app.models.service;

import java.util.List;

import com.grupoq.app.models.entity.EstadoC;

public interface IEstadoService {
	public List<EstadoC> findAllByOrderByEstadoAsc();

}
