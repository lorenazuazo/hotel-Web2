package com.web2.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/categoria")
public class CategoriaController {
	
	@GetMapping(path= {"/"})
	public String index() {
		return "administrator/categoria";
	}

}
