package com.jecheverria.servicios;

import java.util.List;

import com.jecheverria.model.Vacante;

public interface IvacantesServicio {
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	void guardar(Vacante vacante);

}
