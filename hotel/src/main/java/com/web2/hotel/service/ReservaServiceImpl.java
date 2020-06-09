package com.web2.hotel.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web2.hotel.entities.Reservas;
import com.web2.hotel.entities.Reservas.Estado;
import com.web2.hotel.entities.Usuario;
import com.web2.hotel.repositories.ReservaRepository;
import com.web2.hotel.repositories.UserRepository;


@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	ReservaRepository reservaRepo;
	
	@Autowired
	HabitacionService habitacionService;

	@Autowired
	UserRepository userRepo;
	
	@Override
	public Iterable<Reservas> getAllReservas() {
		return reservaRepo.findAll();
	}
	
	


	@Override
	public void registrarReserva(Reservas reserva) throws Exception {
		/*Iterable<Habitacion>habitDisponibles= habitacionService
				.getHabitacionesDisponibles(reserva.getFechaEntrada(), reserva.getFechaSalida());
		if(habitDisponibles==null) {
			throw new Exception("No hay Habitaciones Disponibles");
		}*/
		Usuario usuario=userRepo.findByUsername(reserva.getUsername()).get();
		Reservas toReserva = new Reservas();
		mapReserva(reserva, toReserva,usuario);
		reservaRepo.save(toReserva);
	}
	/*mapeo el usuario desde formUser a toUser*/
	protected void mapReserva(Reservas from,Reservas toReserva,Usuario us) {
		toReserva.setNombre(from.getNombre());;          
		toReserva.setApellido(from.getApellido());
		toReserva.setDni(from.getDni());
		toReserva.setFechaEntrada(from.getFechaEntrada());
		toReserva.setFechaSalida(from.getFechaSalida());
		toReserva.setFechaReserva(LocalDate.now());
		toReserva.setCantHabitaciones(from.getCantHabitaciones());
		toReserva.setCantAdultos(from.getCantAdultos());
		toReserva.setCantNinios(from.getCantNinios());
		toReserva.setEstado(Estado.CONFIRMADA); 
		toReserva.setUsuario(us);
		//toReserva.setHabitacion();
	}

	@Override
	public Iterable<Reservas> getAllReservasConfirmadas() {
		//Estado estado=Estado.CONFIRMADA;
		return reservaRepo.findAllByEstado(Estado.CONFIRMADA);
	}

}
