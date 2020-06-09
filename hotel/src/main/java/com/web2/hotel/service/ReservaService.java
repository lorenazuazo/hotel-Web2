package com.web2.hotel.service;

import com.web2.hotel.entities.Reservas;


public interface ReservaService {
	public Iterable<Reservas> getAllReservas();
	
	public Iterable<Reservas> getAllReservasConfirmadas();
	
	
	public void registrarReserva(Reservas reserva) throws Exception;

}
