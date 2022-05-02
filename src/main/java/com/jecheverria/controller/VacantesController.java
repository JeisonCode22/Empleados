package com.jecheverria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	@GetMapping("/ver/{id}")
	public String verDetalle(@PathVariable("id") int idVacante) {
		System.out.println("Id vacante: "+idVacante);
		return "vacante/detalle";
	}

}
