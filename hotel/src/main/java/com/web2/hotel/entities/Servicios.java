package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SuppressWarnings("serial")
@Table(name="servicios")
@Data @AllArgsConstructor @NoArgsConstructor

public class Servicios implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column
	private long idServicio;
	
	@Column(length=100)
	@NotBlank
	private String nombreServicio;
	
	@Column(length=255)
	@NotBlank
	private String descripcionServicio;
	
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
	        name = "servicio_huesped", 
	        joinColumns = { @JoinColumn(name = "servicio_id")}, 
	        inverseJoinColumns =   {@JoinColumn(name = "huesped_id")})
	private Set<Huesped>huespedServicio;

}
