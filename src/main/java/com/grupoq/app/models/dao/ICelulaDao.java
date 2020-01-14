package com.grupoq.app.models.dao;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.grupoq.app.models.entity.Celula;

public interface ICelulaDao extends PagingAndSortingRepository<Celula, Long> {

	public List<Celula> findAllByOrderByNombrecAsc();
}
