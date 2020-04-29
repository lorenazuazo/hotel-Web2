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
@Table(name="tipoHabitacion")
@Data @AllArgsConstructor @NoArgsConstructor

public class TipoHabitacion implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column
	private long id;
	
	@Column
	@NotBlank
	private String clase;
	
	@Column
	@NotBlank
	private String descripcion;

	@Column
	@NotBlank
	private String dimension;
	
	@Column
	@NotBlank
	private String camas;	
	
	@Column(precision=10, scale=2)
	@NotBlank
	private float tarifa;
	
	/*union con Habitacion*/
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="tipoHabitacion",
			cascade=CascadeType.ALL)
	private Set<Habitacion> habitacion;
	
	/*union con CaracteristicasHabitacion*/
	@ManyToMany(mappedBy="tipohabit")
	private Set<CaracteristicasHabitacion>caractHabitacion;

}
