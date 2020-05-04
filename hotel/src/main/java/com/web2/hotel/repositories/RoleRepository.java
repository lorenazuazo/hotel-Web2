package com.web2.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web2.hotel.entities.Authority;

@Repository
public interface RoleRepository extends CrudRepository<Authority, Long>{

}
