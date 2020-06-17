package com.web2.hotel.service;

import com.web2.hotel.entities.Servicios;

public interface ServiciosService {

    public Iterable<Servicios> getAllServicios();
	
	public Servicios getServicioById(long id)throws Exception;
	
	public void crearServicio(Servicios servicio) throws Exception;
	
	public Servicios updateServicio(Servicios servicio)throws Exception;
	
	public void deleteServicio(long id) throws Exception;
}
