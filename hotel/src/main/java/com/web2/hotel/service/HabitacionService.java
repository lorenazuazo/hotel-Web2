package com.web2.hotel.service;


import java.util.Optional;

import com.web2.hotel.entities.Habitacion;


public interface HabitacionService {
	
	public Iterable<Habitacion> getAllHabitacion();
	
	public Optional<Habitacion> getHabitacionById(long id);


}
