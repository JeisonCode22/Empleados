package com.jecheverria.servicios;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jecheverria.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService {
	private List<Categoria> lista = null;

	public CategoriasServiceImpl() {
		lista = new LinkedList<Categoria>();
		Categoria cat1 = new Categoria();
		cat1.setId(1);
		cat1.setNombre("Contabilidad");
		cat1.setDescripcion("Descripcion de la categoria Contabilidad");
		
		Categoria cat2 = new Categoria();
		cat2.setId(2);
		cat2.setNombre("Ventas");
		cat2.setDescripcion("Trabajos relacionados con Ventas");
		
		Categoria cat3 = new Categoria();
		cat3.setId(3);
		cat3.setNombre("Comunicaciones");
		cat3.setDescripcion("Trabajos relacionados con Comunicaciones");
		
		Categoria cat4 = new Categoria();
		cat4.setId(4);
		cat4.setNombre("Arquitectura");
		cat4.setDescripcion("Trabajos de Arquitectura");
		
		Categoria cat5 = new Categoria();
		cat5.setId(5);
		cat5.setNombre("Educacion");
		cat5.setDescripcion("Maestros, tutores, etc");
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
		lista.add(cat5);
	}

	public void guardar(Categoria categoria) {
		lista.add(categoria);
	}

	public List<Categoria> buscarTodas() {
		return lista;
	}

	public Categoria buscarPorId(Integer idCategoria) {
		for (Categoria cat : lista) {
			if (cat.getId() == idCategoria) {
				return cat;
			}
		}
		return null;
	}

}
