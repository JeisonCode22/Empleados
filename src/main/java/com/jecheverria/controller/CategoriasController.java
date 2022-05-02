package com.jecheverria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		return "categorias/listaCategorias";
	}

	@GetMapping("/crear")
	public String crear() {
		return "categorias/formularioCategorias";
	}

	@PostMapping("/guardar")
	public String guardar() {
		return "categorias/listaCategorias";
	}

}
