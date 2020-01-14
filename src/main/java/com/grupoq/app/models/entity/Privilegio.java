package com.grupoq.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Privilegio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpr")
	private Long idpr;
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Miembro miembropri;
	
	public Privilegio() {
		
	}

	public Long getIdpr() {
		return idpr;
	}

	public void setIdpr(Long idpr) {
		this.idpr = idpr;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
