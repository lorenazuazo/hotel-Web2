package com.web2.hotel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	
	@GetMapping("/modificaciones")
	public String modificarDatos(Model model) {
		model.addAttribute("userForm", new Usuario());/*para guardar las modificaciones*/
		model.addAttribute("userList", userService.getAlluser());/*Lista de usuarios en BBDD*/
		model.addAttribute("roles", roleRepo.findAll());
		model.addAttribute("listTab","active");/*esto dice que ventana esta activa cuando entra*/
		model.addAttribute("displayFormUser","display:none");/*para ocultarlos formularios*/
		return "admin-form";
	}
	
	@PostMapping("/crearUser")
	public String setModificarDatos(@Valid @ModelAttribute("userForm")Usuario user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("displayFormUser","display:block");/*para mostrar formularios*/
			model.addAttribute("formTab", "active");
		}else {
			try {
				userService.createUser(user);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", userService.getAlluser());
				model.addAttribute("roles", roleRepo.findAll());
			}
		}
		
		model.addAttribute("userList", userService.getAlluser());
		model.addAttribute("roles", roleRepo.findAll());
		return "admin-form";
	}
	
	@GetMapping("editUser/{id}")
	public String getEditUserForm(Model model,@PathVariable(name="id")Long id)throws Exception {
		Usuario user= userService.getUserById(id);
		model.addAttribute("displayFormUser","display:block");/*para mostrar formularios*/
		model.addAttribute("userList",userService.getAlluser());
		model.addAttribute("roles",roleRepo.findAll());
		model.addAttribute("userForm",user);
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");/*activo el modo edicion*/
		return "admin-form";
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
