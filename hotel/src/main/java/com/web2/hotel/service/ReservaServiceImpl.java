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
		toReserva.setCantDias(from.getCantDias());
		toReserva.setCantHabitaciones(from.getCantHabitaciones());
		toReserva.setCantAdultos(from.getCantAdultos());
		toReserva.setCantNinios(from.getCantNinios());
		toReserva.setTarifaReserva(from.getTarifaReserva());
		toReserva.setEstado(Estado.CONFIRMADA); 
		toReserva.setUsuario(us);
		toReserva.setHabitacion(from.getHabitacion());
	}

	@Override
	public Iterable<Reservas> getAllReservasConfirmadas() {
		return reservaRepo.findAllByEstado(Estado.CONFIRMADA);
	}


	@Override
	public void deleteReserva(long id) throws Exception {
		Reservas reserva=reservaRepo.findById(id)
				.orElseThrow(()->new Exception("No existe la reserva"));
		reservaRepo.delete(reserva);
		
	}

	@Override
	public Reservas getReservaById(long id) throws Exception {
		Optional<Reservas> reserva= reservaRepo.findById(id);
		if(!reserva.isPresent()) {
			throw new Exception("No existe reserva con ese id");
		}
		return reserva.get();
	}




	@Override
	public Reservas updateReserva(Reservas reservaFrom) throws Exception {
		Optional<Reservas> res=reservaRepo.findById(reservaFrom.getIdReserva());
		if(!res.isPresent()) {
			throw new Exception("No existe reserva");
		}
		
		Reservas reservaTo=res.get();
		reservaMap(reservaFrom,reservaTo);
		return reservaRepo.save(reservaTo);
	}
	
	protected void reservaMap(Reservas from,Reservas reservaTo) {
		reservaTo.setNombre(from.getNombre());;          
		reservaTo.setApellido(from.getApellido());
		reservaTo.setDni(from.getDni());
		reservaTo.setFechaEntrada(from.getFechaEntrada());
		reservaTo.setFechaSalida(from.getFechaSalida());
		reservaTo.setFechaReserva(from.getFechaReserva());
		reservaTo.setCantDias(from.getCantDias());
		reservaTo.setCantHabitaciones(from.getCantHabitaciones());
		reservaTo.setCantAdultos(from.getCantAdultos());
		reservaTo.setCantNinios(from.getCantNinios());
		reservaTo.setTarifaReserva(from.getTarifaReserva());
		reservaTo.setEstado(from.getEstado()); 
		reservaTo.setUsuario(from.getUsuario());
		reservaTo.setHabitacion(from.getHabitacion());
	}

}
