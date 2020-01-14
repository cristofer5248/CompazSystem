package com.grupoq.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.grupoq.app.models.entity.Miembro;


public interface IMiebrostDao extends PagingAndSortingRepository<Miembro, Long> {

	
}