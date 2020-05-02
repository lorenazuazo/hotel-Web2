package com.web2.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web2.hotel.repositories.TipoHabitacionRepository;

@Controller
public class HabitacionesController {
	
	@Autowired
	TipoHabitacionRepository tipohabrepo;
	
	@GetMapping("/habitaciones")
	public String getHabitacion(Model model){
		model.addAttribute("hab",tipohabrepo.findAll());/**para consultar las habitaciones**/
		return "habitaciones";
	}

}
