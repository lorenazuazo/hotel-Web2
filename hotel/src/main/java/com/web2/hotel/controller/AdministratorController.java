package com.web2.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@GetMapping("/home")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login () {
		return "login-form";
	}

	@GetMapping("/registro")
	public String mostratFormRegistro() {
		
		return "registro-formuser";
	}
	
	@GetMapping("/modificaciones")
	public String modificarDatosHotel() {
		
		return "admin-form";
	}
	
	@GetMapping("/fotos")
	public String mostrarCarrusel() {
		
		return "galeria";
	}
	
	@GetMapping("/tarifas")
	public String mostrarTarifas() {
		
		return "tarifas";
	}
	
	@GetMapping("/habitaciones")
	public String getHabitacion(){
		return "habitaciones";
	}
	
	@GetMapping("/ubicacion")
	public String getUbicacion() {
		return "ubicacion";
	}

}
