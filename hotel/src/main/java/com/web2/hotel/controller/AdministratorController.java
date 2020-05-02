package com.web2.hotel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web2.hotel.entities.Newsletters;



@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@GetMapping("/home")
	public String index(Model model) {
		model.addAttribute("email", new Newsletters());/*creando un newsletter para que registre el mail de newsletter*/
		return "index";
	}
	
	@GetMapping("/modificaciones")
	public String modificarDatosHotel() {
		return "admin-form";
	}
	
	@GetMapping("/fotos")
	public String mostrarGaleria() {
		return "galeria";
	}
	
	@GetMapping("/tarifas")
	public String mostrarTarifas() {
		return "tarifas";
	}
	
	
}
