package com.web2.hotel.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.hotel.entities.Habitacion;
import com.web2.hotel.repositories.HabitacionRepository;

@Service
public class HabitacionServiceImpl implements HabitacionService{

	@Autowired
	HabitacionRepository habitacionRepo;

	@Override
	public Iterable<Habitacion> getAllHabitacion() {
		return habitacionRepo.findAll();
	}

	@Override
	public Habitacion getHabitacionById(long id) throws Exception {
		Optional<Habitacion> habitacion= habitacionRepo.findById(id);
		if(!habitacion.isPresent()) {
			throw new Exception("No existe habitacion con ese id");
		}
		return habitacion.get();
	}

	@Override
	public Habitacion createHabitacion(Habitacion habitacion) throws Exception {
		Habitacion hab= habitacionRepo.save(habitacion);
		return hab;
	}

	@Override
	public Habitacion updateHabitacion(Habitacion habitacionFrom) throws Exception {
		Optional<Habitacion> hab=habitacionRepo.findById(habitacionFrom.getId_habitacion());
		if(!hab.isPresent()) {
			throw new Exception("No existe habitacion");
		}
		
		Habitacion habitacionTo=hab.get();
		habMap(habitacionFrom,habitacionTo);
		return habitacionRepo.save(habitacionTo);
	}
	
	protected void habMap(Habitacion from,Habitacion habitacionTo) {
		habitacionTo.setNumerohabitacion(from.getNumerohabitacion());
		habitacionTo.setTarifa(from.getTarifa());
		habitacionTo.setDescripcion(from.getDescripcion());
		habitacionTo.setTipoHabitacion(from.getTipoHabitacion());
		habitacionTo.setCaractehabitacion(from.getCaractehabitacion());
	}
	
}
