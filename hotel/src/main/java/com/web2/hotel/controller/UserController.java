package com.web2.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web2.hotel.entities.Usuario;
import com.web2.hotel.repositories.UserRepository;


@Controller
@RequestMapping("/")
public class UserController {

	@GetMapping(path= {"/inicio","/"})
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
	

}
