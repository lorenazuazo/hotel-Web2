package com.web2.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web2.hotel.entities.Mensajes;
import com.web2.hotel.entities.Project;
import com.web2.hotel.repositories.MensajeRepository;
import com.web2.hotel.repositories.TipoHabitacionRepository;
import com.web2.hotel.service.MensajeService;
import com.web2.hotel.service.MensajeServiceImpl;

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
	
	@Autowired
	TipoHabitacionRepository tipohabrepo;
	
	@GetMapping("/habitaciones")
	public String getHabitacion(Model model){
		model.addAttribute("hab",tipohabrepo.findAll());/**para consultar las habitaciones**/
		return "habitaciones";
	}
	
	@GetMapping("/mensaje")
	public String getMensaje(Model model) {
		model.addAttribute("mensajes", new Mensajes());/*creando un mensaje que se guarda en la variable mensaje*/
		return "mensaje";
	}
	
    @Autowired
	MensajeRepository mensajeRepo;
	
	@PostMapping("/save-mensaje")
	public String setMensaje(@ModelAttribute Mensajes mens) {
		mensajeRepo.save(mens);
		return "redirect:/mensaje";
	}
	
}
