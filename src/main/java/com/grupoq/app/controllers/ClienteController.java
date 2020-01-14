package com.grupoq.app.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.grupoq.app.models.service.IClienteService;
import com.grupoq.app.models.service.IUploadFileService;
import com.grupoq.app.models.entity.Miembro;
//import com.bolsadeideas.springboot.app.models.entity.Cliente;
//import com.bolsadeideas.springboot.app.models.service.IClienteService;
//import com.bolsadeideas.springboot.app.models.service.IUploadFileService;
import com.grupoq.app.util.paginator.PageRender;

@Controller
@SessionAttributes("miembro")
public class ClienteController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IUploadFileService uploadFileService;

	@Secured({ "ROLE_USER" })
	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

//	@PreAuthorize("hasRole('ROLE_USER')")
//	@GetMapping(value = "/vercliente/{id}")
//	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
//
//		Taller taller = clienteService.findByIdTallerWithClienteWithFactura(id);
////		List<?> taller = facturaService.probando(id);
//		Cliente cliente;
//		if (taller == null) {
//			cliente = clienteService.findOne(id);
//			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
//			model.put("cliente", cliente);
//			model.put("titulo", "Detalle cliente: " + cliente.getNombre());
//			return "vercliente";
//		}
//
//		model.put("taller", taller);
//		model.put("cliente", taller.getCliente());
//		model.put("titulo", "Detalle cliente: " + taller.getCliente().getNombre());
//		return "vercliente";
//	}

	@RequestMapping(value = { "/miembros", "/" }, method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model,
			Authentication authentication, HttpServletRequest request) {

		if (authentication != null) {
			logger.info("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			logger.info(
					"Utilizando forma estática SecurityContextHolder.getContext().getAuthentication(): Usuario autenticado: "
							.concat(auth.getName()));
		}

		if (hasRole("ROLE_ADMIN")) {
			logger.info("Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}

		SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request,
				"");

		if (securityContext.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName())
					.concat(" tienes acceso!"));
		} else {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName())
					.concat(" NO tienes acceso!"));
		}

		if (request.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}

		Pageable pageRequest = PageRequest.of(page, 5);

		Page<Miembro> clientes = clienteService.findAll(pageRequest);

		PageRender<Miembro> pageRender = new PageRender<Miembro>("/miembros", clientes);
		model.addAttribute("titulo", "Listado de miembros");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
		return "listar";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/ovejaform")
	public String crear(Map<String, Object> model) {

		Miembro miembro = new Miembro();
		model.put("miembro", miembro);
		model.put("titulo", "Nueva solicitud");
		return "ovejaform";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/ovejaform/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Miembro miembro = null;

		if (id > 0) {
			miembro = clienteService.findOne(id);
			if (miembro == null) {
				flash.addFlashAttribute("error", "El ID de la oveja no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("miembro", miembro);
		model.put("titulo", "Editar Miembro");
		return "ovejaform";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/ovejasave", method = RequestMethod.POST)
	public String guardar(@Valid Miembro miembro, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Ovejas");
			return "ovejaform";
		}

		if (!foto.isEmpty()) {

			if (miembro.getId() != null && miembro.getId() > 0 && miembro.getFoto() != null
					&& miembro.getFoto().length() > 0) {

				uploadFileService.delete(miembro.getFoto());
			}

			String uniqueFilename = null;
			try {
				uniqueFilename = uploadFileService.copy(foto);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");

			miembro.setFoto(uniqueFilename);
			miembro.setCodigo("aver");

		}

		String mensajeFlash = (miembro.getId() != null) ? "Oveja editado con éxito!" : "Oveja creado con éxito!";

		clienteService.save(miembro);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:miembros";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/ovejaeliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			Miembro miembro = clienteService.findOne(id);

			clienteService.delete(id);
			flash.addFlashAttribute("success", "Oveja eliminada con éxito!");

			if (uploadFileService.delete(miembro.getFoto())) {
				flash.addFlashAttribute("info", "Foto " + miembro.getFoto() + " eliminada con exito!");
			}

		}
		return "redirect:/miembros";
	}

	private boolean hasRole(String role) {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null) {
			return false;
		}
		Authentication auth = context.getAuthentication();
		if (auth == null) {
			return false;
		}
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if (role.equals(authority.getAuthority())) {
				return true;
			}
		}
		return false;
	}
}
