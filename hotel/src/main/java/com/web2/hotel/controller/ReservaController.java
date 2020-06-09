package com.web2.hotel.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web2.hotel.entities.Habitacion;
import com.web2.hotel.entities.Reservas;
import com.web2.hotel.service.HabitacionService;
import com.web2.hotel.service.ReservaService;


@Controller
public class ReservaController {
	
	@Autowired
	ReservaService reservaService;
	
	@Autowired
	HabitacionService habitacionService;
	
	@GetMapping("/reserva")
	public String getReserva(Model model) {
		model.addAttribute("reservaForm", new Reservas());
		model.addAttribute("ModoConsulta","true");/*activo la consulta por la leyenda del boton*/
		return "reservas";
	}
	
	@PostMapping("/disponibilidad")
	public String getDisponibilidad(@Valid @ModelAttribute("reservaForm")Reservas reserva , BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("reservaForm", reserva);
			model.addAttribute("ModoConsulta","true");
		}else {
			try {
				model.addAttribute("reservaForm", reserva);
				Iterable<Habitacion> habitacion=habitacionService.getHabitacionesDisponibles(reserva);
				model.addAttribute("habitacionesdispoble", habitacion);
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("reservaForm", reserva);
				model.addAttribute("ModoConsulta","true");
			}
		}
		return "confirmahabitacion";
	}
	
	@PostMapping("/reserva")
	public String setReserva(@Valid @ModelAttribute("reservaForm")Reservas reserva , BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("reservaForm", reserva);
			model.addAttribute("ModoConsulta","true");
		}else {
			try {

				reservaService.registrarReserva(reserva);
				model.addAttribute("reservaForm", new Reservas());
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("reservaForm", reserva);
			}
		}
		return "confirmahabitacion";
	}

}
