package com.web2.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.hotel.entities.Mensajes;
import com.web2.hotel.repositories.MensajeRepository;

@Service
public class MensajeServiceImpl implements MensajeService{
	
	@Autowired
	MensajeRepository mensajeRepo;
	
	@Override
	public Iterable<Mensajes> getAllmensaje() {
		return mensajeRepo.findAll();
	}

}
