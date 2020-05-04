package com.web2.hotel.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web2.hotel.entities.Usuario;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long>{
	
	public Optional<Usuario> findByIdAndPassword(Long id, String password);
	
	public Optional<Usuario> findByUsername(String username);
	
	

}