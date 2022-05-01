package com.jecheverria.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jecheverria.model.Vacante;

@Controller
public class HomeController {
	@GetMapping("/")
	public String mostrarHome() {
		return "home";
	}
	@GetMapping("/tabla")
	public String mostrarTable(Model model) {
		List <Vacante> lista = getVacantes();
		model.addAttribute("vacantes", lista);
		return"tabla";
	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		model.addAttribute("empleos", lista);
		return "listado";
	}

	@GetMapping("detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicacion");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.00);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}

	private List<Vacante> getVacantes() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Se solicita ing. civil");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(8500.00);

			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Se solicita contador publico");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);

			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero electrico");
			vacante3.setDescripcion("Se solicita ing electrico");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(10500.0);

			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador grafico");
			vacante4.setDescripcion("Se solicita diseñador grafico");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(7500.0);

			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lista;
	}

}
