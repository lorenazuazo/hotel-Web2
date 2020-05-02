package com.web2.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String login () {
		return "login-form";
	}

	@GetMapping("/registro")
	public String mostratFormRegistro() {
		return "registro-formuser";
	}
	
	@GetMapping("/mis-datos")
	public String setDatos() {
		return "modif-datos";
	}

}
