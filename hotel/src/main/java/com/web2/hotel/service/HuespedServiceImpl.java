package com.web2.hotel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.hotel.entities.Huesped;
import com.web2.hotel.entities.Usuario;
import com.web2.hotel.repositories.HuespedRepository;

@Service
public class HuespedServiceImpl implements HuespedService{

	@Autowired
	HuespedRepository huespedRepo;
	
	@Override
	public Iterable<Huesped> getAllHuesped() {
		return huespedRepo.findAll() ;
	}
	
	/*chequear que el huesped este disponible*/
	private boolean checkHuespedDisponible(Huesped huesped) throws Exception{
		Optional<Huesped> huespedFound= huespedRepo.findById(huesped.getId());
		if(huespedFound.isPresent()) {
			throw new Exception("Huesped ya creado");
		}
		return true;
	}

	@Override
	public Huesped createHuesped(Huesped huesped) throws Exception {
		Huesped huesp = null;
		if(checkHuespedDisponible(huesped)) {
			huesp = huespedRepo.save(huesped);
		}
		return huesp;
	}

	@Override
	public Huesped getHuespedById(long id) throws Exception {
		Huesped huesped=huespedRepo.findById(id).orElseThrow(()->new Exception("No existe Huesped"));
		return huesped;
	}

	@Override
	public Huesped updateHuesped(Huesped fromHuesped) throws Exception {
		Optional<Huesped> huesp= huespedRepo.findById(fromHuesped.getId());
		if (!huesp.isPresent()) {
			   throw new Exception("No existe el huesped");
			}

		Huesped toHuesped = huesp.get();
		mapHuesped(fromHuesped, toHuesped);
		return huespedRepo.save(toHuesped);
	}
	/*mapeo el usuario desde formUser a toUser*/
	protected void mapHuesped(Huesped from,Huesped toHuesped) {
		toHuesped.setNombre(from.getNombre());          
		toHuesped.setApellido(from.getApellido());
		toHuesped.setSexo(from.getSexo());
		toHuesped.setCorreo(from.getCorreo());
		toHuesped.setDni(from.getDni());
		toHuesped.setEdad(from.getEdad());
		toHuesped.setTelefono(from.getTelefono());
	}

	@Override
	public void deleteHuesped(long id) throws Exception {
		Huesped huesped=huespedRepo.findById(id).orElseThrow(()-> new Exception("No existe el huesped"));
		huespedRepo.delete(huesped);
		
	}

}
