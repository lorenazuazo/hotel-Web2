package com.web2.hotel.service;

import com.web2.hotel.entities.Habitacion;


public interface HabitacionService {
	
	public Iterable<Habitacion> getAllHabitacion();
	
	public Habitacion getHabitacionById(long id)throws Exception;
	
	public Habitacion createHabitacion(Habitacion habitacion)throws Exception;
	
	public Habitacion updateHabitacion(Habitacion habitacion)throws Exception;


}
