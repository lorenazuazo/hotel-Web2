package com.web2.hotel.controller;


import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web2.hotel.entities.Habitacion;
import com.web2.hotel.entities.Usuario;
import com.web2.hotel.repositories.CaracteristicasHabitacionRepository;
import com.web2.hotel.repositories.HabitacionRepository;
import com.web2.hotel.repositories.RoleRepository;
import com.web2.hotel.repositories.TipoHabitacionRepository;
import com.web2.hotel.repositories.UserRepository;
import com.web2.hotel.service.CaracteristicasHabitacionService;
import com.web2.hotel.service.HabitacionService;
import com.web2.hotel.service.TipoHabitacionService;
import com.web2.hotel.service.UserService;

@Controller
@RequestMapping("/modificaciones")
public class ModificacionesControler {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping("/")
	public String getModificaciones() {
		return "admin-form";
	}
	
	@GetMapping("/usuario")
	public String getUsuarios(Model model) {
		model.addAttribute("userForm", new Usuario());/*para guardar las modificaciones*/
		model.addAttribute("userList", userService.getAlluser());/*Lista de usuarios en BBDD*/
		model.addAttribute("roles", roleRepo.findAll());
		model.addAttribute("listTab","active");/*esto dice que ventana esta activa cuando entra*/
		return "admin-form-user";
	}
	
	@PostMapping("/crearUser")
	public String setModificarDatos(@Valid @ModelAttribute("userForm")Usuario user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
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
		return "admin-form-user";
	}
	
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model,@PathVariable(name="id")Long id) throws Exception {
		Usuario user= userService.getUserById(id);
		model.addAttribute("userList",userService.getAlluser());
		model.addAttribute("roles",roleRepo.findAll());
		model.addAttribute("userForm",user);
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");/*activo el modo edicion*/
		return "admin-form-user";
	}
	
	@PostMapping("/editUser")
	public String setUserEdit(@Valid @ModelAttribute("userForm")Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode","true");/*activo el modo edicion*/
		}else {
			try {
				userService.updateUser(user);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", userService.getAlluser());
				model.addAttribute("roles", roleRepo.findAll());
				model.addAttribute("editMode","true");/*activo el modo edicion*/

			}
		}
		
		model.addAttribute("userList", userService.getAlluser());
		model.addAttribute("roles", roleRepo.findAll());
		return "admin-form-user";		
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id") Long id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			model.addAttribute("deleteError","No se pudo eliminar el usuario");
		}
		return getUsuarios(model); //es lo mismo que redirect per mantengo el mensaje de error
	}
	
	@GetMapping("/usuario/cancel")
	public String cancelEditUser(Model model) {
		return "redirect:/modificaciones/usuario";
	}
	
	/*modificaciones de habitaciones*/
	@Autowired
	HabitacionService habitacionService;
	@Autowired
	TipoHabitacionService tipoHabService;
	@Autowired
	CaracteristicasHabitacionService caractHabitService;
	
	
	@GetMapping("/habitaciones")
	public String getHabitaciones(Model model) {
		model.addAttribute("habForm", new Habitacion());/*para guardar las modificaciones*/
		model.addAttribute("habitacionList", habitacionService.getAllHabitacion());/*Lista de habit en BBDD*/
		model.addAttribute("tipos",tipoHabService.getAllTiposHabitacion());
		model.addAttribute("caractHabitacion",caractHabitService.getAllCaractHabitacion());
		model.addAttribute("listTab","active");/*esto dice que ventana esta activa cuando entra*/
		return "admin-form-habitacion";
	}
	
	@PostMapping("/crearHabitacion")
	public String setModificarHabitacion(@Valid @ModelAttribute("habForm")Habitacion habitacion, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("habForm", habitacion);
			model.addAttribute("formTab", "active");
		}else {
			try {
				habitacionService.createHabitacion(habitacion);
				model.addAttribute("habForm", new Habitacion());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("habForm", habitacion);
				model.addAttribute("formTab", "active");
				model.addAttribute("habitacionList", habitacionService.getAllHabitacion());
				model.addAttribute("tipos",tipoHabService.getAllTiposHabitacion());
				model.addAttribute("caractHabitacion",caractHabitService.getAllCaractHabitacion());
			}
			
			model.addAttribute("habitacionList",habitacionService.getAllHabitacion());
			model.addAttribute("tipos",tipoHabService.getAllTiposHabitacion());
			model.addAttribute("caractHabitacion",caractHabitService.getAllCaractHabitacion());
		}

		return "admin-form-habitacion";
	}
	
	@GetMapping("/editHabitacion/{id}")
	public String getStringEditHabitcion(Model model,@PathVariable(name="id")Long id)throws Exception {
		Habitacion hab= habitacionService.getHabitacionById(id);
		model.addAttribute("habitacionList", habitacionService.getAllHabitacion());
		model.addAttribute("tipos",tipoHabService.getAllTiposHabitacion());
		model.addAttribute("caractHabitacion",caractHabitService.getAllCaractHabitacion());
		model.addAttribute("habForm",hab);
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");/*activo el modo edicion*/
		return "admin-form-habitacion";
	}
	
	@PostMapping("/editHabitacion")
	public String seteditHabitacion(@Valid @ModelAttribute("habForm")Habitacion habitacion, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("habForm", habitacion);
			model.addAttribute("formTab", "active");
		}else {
			try {
				habitacionService.updateHabitacion(habitacion);
				model.addAttribute("habForm", new Habitacion());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("habForm", habitacion);
				model.addAttribute("formTab", "active");
				model.addAttribute("habitacionList", habitacionService.getAllHabitacion());
				model.addAttribute("tipos",tipoHabService.getAllTiposHabitacion());
				model.addAttribute("caractHabitacion",caractHabitService.getAllCaractHabitacion());
			}
			
			model.addAttribute("habitacionList",habitacionService.getAllHabitacion());
			model.addAttribute("tipos",tipoHabService.getAllTiposHabitacion());
			model.addAttribute("caractHabitacion",caractHabitService.getAllCaractHabitacion());
		}

		return "admin-form-habitacion";
	}
	
	@GetMapping("/habitaciones/cancel")
	public String cancelEditHabitacion(Model model) {
		return "redirect:/modificaciones/habitaciones";
	}

}
