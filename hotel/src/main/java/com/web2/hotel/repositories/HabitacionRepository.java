package com.web2.hotel.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.web2.hotel.entities.Habitacion;



@Repository
public interface HabitacionRepository extends CrudRepository<Habitacion, Long>{
	
	public ArrayList<Habitacion> findByReservaNotNull();
	
	public Iterable<Habitacion> findAllByOrderByCantidadhuespedDescTarifaDesc();

}
