package dao;

import java.util.List;

import model.Reserva;

public interface ReservasDao {

	public void generarReserva(Reserva reserva);
	
	public List<Reserva> getReservas();
	
}
