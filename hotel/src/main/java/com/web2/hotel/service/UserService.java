package com.web2.hotel.service;

import java.util.Optional;

import com.web2.hotel.entities.Usuario;

public interface UserService {
	
	public Iterable<Usuario> getAlluser();
	
	public Usuario createUser(Usuario formUser) throws Exception;
	
	public Usuario getUserById(long id)throws Exception;

	public Optional<Usuario> getUserByUsername(String username);
	

}
