package com.web2.hotel.service;

import com.web2.hotel.entities.Usuario;

public interface UserService {
	
	public Iterable<Usuario> getAlluser();
	
	public Usuario createUser(Usuario formUser) throws Exception;
	
	public String getUsuarioLogueado();
	

}
