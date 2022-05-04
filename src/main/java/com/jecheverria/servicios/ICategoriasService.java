package com.jecheverria.servicios;

import java.util.List;
import com.jecheverria.model.Categoria;

public interface ICategoriasService {
	void guardar(Categoria categoria);

	List<Categoria> buscarTodas();

	Categoria buscarPorId(Integer idCategoria);
}