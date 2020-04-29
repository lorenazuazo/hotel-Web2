package com.web2.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web2.hotel.entities.Habitacion;

@Repository
public interface HabitacionRepository extends CrudRepository<Habitacion, Long>{
	
}
