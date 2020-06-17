package com.web2.hotel.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.web2.hotel.entities.Usuario;
import com.web2.hotel.repositories.RoleRepository;
import com.web2.hotel.repositories.UserRepository;
import com.web2.hotel.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping("/login")
	public String login (Model model) {
		return "login-form";
	}

	@GetMapping("/registro")
	public String mostratFormRegistro() {
		return "registro-formuser";
	}
	
	@GetMapping("/mis-datos/{username}")
	public String getDatos(Model model,@PathVariable(name="username")String username){
		model.addAttribute("userLogin",userService.getUserByUsername(username));
		model.addAttribute("roles",roleRepo.findAll());
		return "modif-datos";
	}

	@PostMapping("/mis-datos")
	public String setDatos(Model model,@Valid @ModelAttribute("userLogin")Usuario user, BindingResult result) {
		
		return "modif-datos";
	}
}
