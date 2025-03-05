package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService {

	@Autowired
	VuelosDao dao;
	
	@Override
	public List<Vuelo> recuperarVuelosDisponibles(int plazas) {
		List<Vuelo> vuelos = dao.devolverVuelos();
		List<Vuelo> vuelosDisponibles = vuelos.stream()
				.filter((Vuelo vuelo) -> vuelo.getPlazas() >= plazas)
				.collect(Collectors.toList());
		return vuelosDisponibles;
	}

	@Override
	public void actualizarPlazas(int id, int plazas) {
		Vuelo vuelo = dao.devolverVuelo(id);
		if(vuelo != null)
		{
			vuelo.setPlazas(vuelo.getPlazas() - plazas);
			dao.actualizarVuelo(vuelo);
		}
	}

}
