package com.web2.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.hotel.entities.CaracteristicasHabitacion;
import com.web2.hotel.repositories.CaracteristicasHabitacionRepository;

@Service
public class CaracteristicasHabitacionServiceImpl implements CaracteristicasHabitacionService{

	@Autowired
	CaracteristicasHabitacionRepository caracteristicasHabRepo;
	@Override
	public Iterable<CaracteristicasHabitacion> getAllCaractHabitacion() {
		return caracteristicasHabRepo.findAll();
	}

}
