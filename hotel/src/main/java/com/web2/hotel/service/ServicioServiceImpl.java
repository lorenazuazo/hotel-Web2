package com.web2.hotel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.hotel.entities.Newsletters;
import com.web2.hotel.entities.Servicios;
import com.web2.hotel.entities.Usuario;
import com.web2.hotel.repositories.ServiciosRepository;

@Service
public class ServicioServiceImpl implements ServiciosService{
	@Autowired
	ServiciosRepository servicioRepo;

	@Override
	public Iterable<Servicios> getAllServicios() {
		return servicioRepo.findAll();
	}

	@Override
	public Servicios getServicioById(long id) throws Exception {
		Servicios service=servicioRepo.findById(id).orElseThrow(()->new Exception("No existe Servicio"));
		return service;
	}
	
	private boolean checkServicioDisponible(Servicios servicio) throws Exception{
		Optional<Servicios> service= servicioRepo.findById(servicio.getIdServicio());
		if(service.isPresent()) {
			throw new Exception("Servicio ya registrado");
		}
		return true;
	}

	@Override
	public void crearServicio(Servicios servicio) throws Exception {
		if(checkServicioDisponible(servicio)) {
			servicioRepo.save(servicio);
		}
	}

	@Override
	public Servicios updateServicio(Servicios fromServicio) throws Exception {
		Optional<Servicios> serv= servicioRepo.findById(fromServicio.getIdServicio());
		if (!serv.isPresent()) {
			   throw new Exception("No existe el servicio");
			}

		Servicios toServicio = serv.get();
		mapServicio(fromServicio, toServicio);
		return servicioRepo.save(toServicio);
	}
	/*mapeo el servicio desde formServicio a toServicio*/
	protected void mapServicio(Servicios from,Servicios toServicio) {
		toServicio.setDescripcionServicio(from.getDescripcionServicio());          
		toServicio.setCostoServicio(from.getCostoServicio());
	}

	@Override
	public void deleteServicio(long id) throws Exception {
		Servicios servicio=servicioRepo.findById(id).orElseThrow(()-> new Exception("No existe el servicio"));
		servicioRepo.delete(servicio);
		
	}

}
