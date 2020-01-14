package com.grupoq.app.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.grupoq.app.models.service.ICelulaService;
import com.grupoq.app.models.entity.Celula;


@Controller
@RequestMapping("/celula")
@SessionAttributes("celula")
public class CelulaController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private ICelulaService celulaService;

	@GetMapping(value = "/cargar_celulas", produces = { "application/json" })
	public @ResponseBody List<Celula> celulasTodosJson() {
		List<Celula> list = celulaService.findAllByOrderByNombrecAsc();
		return list;
	}

}
