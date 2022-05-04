package com.jecheverria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jecheverria.model.Categoria;
import com.jecheverria.servicios.ICategoriasService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {

	@Autowired
	private ICategoriasService serviceCategorias;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = serviceCategorias.buscarTodas();
		model.addAttribute("categorias", lista);
		return "categorias/listCategorias";
	}

	@GetMapping("/crear")
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}

	@PostMapping("/guardar")
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "categorias/formCategoria";
		}

		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "Los datos de la categoría fueron guardados!");
		return "redirect:/categorias/index";
	}

}
