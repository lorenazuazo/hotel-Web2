package com.web2.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.web2.hotel.entities.Newsletters;

import com.web2.hotel.service.NewsletterService;



@Controller
public class NewslattersController {
	
	@Autowired
	NewsletterService newletterService;
	
	
	/*para guerdar el correo de newsletter*/
	@PostMapping("/save-correo")
	public String setCorreo(@ModelAttribute Newsletters email, Model model) throws Exception {
		try {
			newletterService.registratEmail(email);
			
		} catch (Exception e) {
			model.addAttribute("formErrorMessage",e.getMessage());/*le pongo form delante de eerorMessage para decirle donde lo va a mostrar al mensaje*/
		}
		
		return "redirect:/home";
	}
}
