package com.web2.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web2.hotel.entities.TipoHabitacion;
import com.web2.hotel.repositories.TipoHabitacionRepository;

@Service
public class TipoHabitacionServiceImpl implements TipoHabitacionService{

	@Autowired
	TipoHabitacionRepository tipoHabRepo;
	@Override
	public Iterable<TipoHabitacion> getAllTiposHabitacion() {
		return tipoHabRepo.findAll();
	}

}
