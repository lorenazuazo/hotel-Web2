package com.web2.hotel.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/modificaciones")
	public String modificarDatos(Model model) {
		model.addAttribute("userForm", new Usuario());/*para guardar las modificaciones*/
		model.addAttribute("userList", userService.getAlluser());/*Lista de usuarios en BBDD*/
		model.addAttribute("roles", roleRepo.findAll());
		model.addAttribute("listTab","active");/*esto dice que ventana esta activa cuando entra*/
		model.addAttribute("displayFormUser","display:none");/*para ocultarlos formularios*/
		return "admin-form";
	}
	
	@PostMapping("/modificar-user")
	public String setModificarDatos(@Valid @ModelAttribute("userForm")Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("displayFormUser","display:block");/*para ocultarlos formularios*/
			model.addAttribute("formTab", "active");
		}else {
			try {
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formError", e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab", "active");
			}
		}
		
		model.addAttribute("userList", userService.getAlluser());
		model.addAttribute("roles", roleRepo.findAll());
		return "admin-form";
	}
	
	
	@GetMapping("/mis-datos")
	public String getDatos(Model model) {
		model.addAttribute("user", new Usuario());/*creando un usuario que guarda en la variable userForm*/
		//model.addAttribute("userRegistrado", userRepo.findByUsername(username));
		return "modif-datos";
	}

	@PostMapping("/mis-datos")
	public String setDatos(Model model) {
		//model.addAttribute("user", userRepo.findByUsername(username));
		return "modif-datos";
		
	}
}
