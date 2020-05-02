package com.web2.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web2.hotel.entities.Mensajes;
import com.web2.hotel.repositories.MensajeRepository;

@Controller
public class MensajeController {
	
	@Autowired
	MensajeRepository mensajeRepo;
	
	@GetMapping("/mensaje")
	public String getMensaje(Model model) {
		model.addAttribute("mensajes", new Mensajes());/*creando un mensaje que se guarda en la variable mensaje*/
		return "mensaje";
	}
	
	@PostMapping("/save-mensaje")
	public String setMensaje(@ModelAttribute Mensajes mens) {
		mensajeRepo.save(mens);
		return "redirect:/mensaje";
	}
	

}
