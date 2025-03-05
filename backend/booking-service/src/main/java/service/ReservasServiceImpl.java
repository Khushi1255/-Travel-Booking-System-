package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;


@Service
public class ReservasServiceImpl implements ReservasService {

	@Autowired
	ReservasDao dao;
	
	@Autowired
	RestTemplate template;
	
	//Esto a lo que sustituye es a la combinacion servidor:puerto
	String url = "http://flight-service";
	
	@Override
	public void realizarReserva(Reserva reserva, int totalPersonas) {
		this.dao.generarReserva(reserva);
		//Como no le pasamos nada en el cuerpo ponemos null
		//template.put(url + "/vuelos/" + reserva.getVuelo() + "/" + totalPersonas, null);
		//Otra Manera:
		template.put(url + "/vuelos/{p1}/{p2}", null, reserva.getVuelo() , totalPersonas);
	}

	@Override
	public List<Reserva> getReservas() {
		return this.dao.getReservas();
	}

}
