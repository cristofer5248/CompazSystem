package com.grupoq.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grupoq.app.models.entity.EstadoC;
import com.grupoq.app.models.service.IEstadoService;

@Controller
@RequestMapping("/estado")
public class EstadoCivilController {
	@Autowired
	private IEstadoService estadoService;

	@GetMapping(value = "/cargar_estado", produces = { "application/json" })
	public @ResponseBody List<EstadoC> celulasTodosJson() {
		List<EstadoC> list = estadoService.findAllByOrderByEstadoAsc();
		return list;
	}
}
