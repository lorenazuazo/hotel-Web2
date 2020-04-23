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

}
