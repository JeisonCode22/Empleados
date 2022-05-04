package com.jecheverria.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jecheverria.model.Vacante;
import com.jecheverria.servicios.IvacantesServicio;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	@Autowired
	private IvacantesServicio servicioVacantes;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Vacante> lista = servicioVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "vacantes/listVacantes";
	}

	@PostMapping("/guardar")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
		servicioVacantes.guardar(vacante);
		attributes.addFlashAttribute("msg", "Registro guardado");
		System.out.println(vacante);
		return "redirect:/vacantes/index";
	}

	@GetMapping("/crear")
	public String crear(Vacante vacante) {
		return "vacantes/formVacante";
	}

	@GetMapping("/ver/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = servicioVacantes.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}

	@GetMapping("/borrar")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando vacante con ID: " + idVacante);
		model.addAttribute("vacante", idVacante);
		return "mensaje";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
