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
		if(user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirmar Password es obligatorio");
		}
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


	@Override
	public Usuario getUserById(long id) throws Exception {
		Usuario user=usuarioRepo.findById(id).orElseThrow(()->new Exception("No existe Usuario"));
		return user;
	}

	@Override
	public Optional<Usuario> getUserByUsername(String username) {
		Optional<Usuario> user= usuarioRepo.findByUsername(username);
		return user;
	}

	@Override
	public Usuario updateUser(Usuario formUser) throws Exception {
		Optional<Usuario> user= usuarioRepo.findById(formUser.getId());
		if (!user.isPresent()) {
			   throw new Exception("No existe el usuario.");
			}

		Usuario toUser = user.get();
		mapUser(formUser, toUser);
		return usuarioRepo.save(toUser);
	}
	/*mapeo el usuario desde formUser a toUser*/
	protected void mapUser(Usuario from,Usuario toUser) {
		toUser.setNombre(from.getNombre());          
		toUser.setApellido(from.getApellido());
		toUser.setCorreo(from.getCorreo());
		toUser.setDni(from.getDni());
		toUser.setTelefono(from.getTelefono());
		toUser.setUsername(from.getUsername());
		toUser.setAuthority(from.getAuthority());
	
	}

	@Override
	public void deleteUser(long id) throws Exception {
		Usuario user=usuarioRepo.findById(id).orElseThrow(()-> new Exception("No existe el usuario"));
		usuarioRepo.delete(user);
	}
}
