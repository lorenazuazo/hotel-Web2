package com.web2.hotel.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.hotel.entities.Usuario;
import com.web2.hotel.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository usuarioRepo;
	
	
	@Override
	public String getUsuarioLogueado() {
		return null;
	}


	@Override
	public Iterable<Usuario> getAlluser() {
		return usuarioRepo.findAll() ;
	}

	/*chequear que el username este disponible*/
	private boolean checkUsernameDisponible(Usuario user) throws Exception{
		Optional<Usuario> userFound= usuarioRepo.findByUsername(user.getUsername());
		if(userFound.isPresent()) {
			throw new Exception("Username no disponible");
		}
		return true;
	}
	
	/*chequear pass valido*/
	private boolean checkPassValido(Usuario user)throws Exception{
		if(!user.getPassword().equals(user.getConfirmPassword())){
			throw new Exception("Password y Confirmar Password no son iguales");			
		}
		return true;
	}
	@Override
	public Usuario createUser(Usuario user) throws Exception {
		if(checkUsernameDisponible(user)&& checkPassValido(user)) {
			user = usuarioRepo.save(user);
		}
		return user;
	}


}
