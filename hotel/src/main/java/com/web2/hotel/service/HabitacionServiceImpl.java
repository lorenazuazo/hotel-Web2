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
	public Optional<Habitacion> getHabitacionById(long id) {
		Optional<Habitacion> hab=habitacionRepo.findById(id);
		return hab;
	}


}
