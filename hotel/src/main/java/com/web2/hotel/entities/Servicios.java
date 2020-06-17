package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.web2.hotel.entities.TipoHabitacion.Estado;

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
	
	@Column(length=255)
	@NotBlank
	private String descripcionServicio;
	
	@Column
	@NotNull
	private int costoServicio;
	
	
	@Column
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	public enum Estado {
		VIGENTE,FUERA_DE_SERVICIO
	}
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
	        name = "servicio_huesped", 
	        joinColumns = { @JoinColumn(name = "servicio_id")}, 
	        inverseJoinColumns =   {@JoinColumn(name = "huesped_id")})
	private Set<Huesped>huespedServicio;

}
