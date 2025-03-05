package service;

import java.util.List;

import model.Reserva;

public interface ReservasService {
	
	public void realizarReserva(Reserva reserva, int totalPersonas);
	
	public List<Reserva> getReservas();

}
