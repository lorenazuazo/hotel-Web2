package com.web2.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.web2.hotel.entities.Mensajes;

@Repository
public interface MensajeRepository extends CrudRepository<Mensajes, Long>{

}
