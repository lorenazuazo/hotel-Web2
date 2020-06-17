package com.web2.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.web2.hotel.entities.Servicios;

@Repository
public interface ServiciosRepository extends CrudRepository<Servicios, Long>{

}
