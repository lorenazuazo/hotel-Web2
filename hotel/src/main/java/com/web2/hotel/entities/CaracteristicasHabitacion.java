package com.web2.hotel.entities;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SuppressWarnings("serial")
@Table(name="caracteristicashabitacion")
@Data @AllArgsConstructor @NoArgsConstructor

public class CaracteristicasHabitacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column
	private long id;
	
	@Column
	@NotBlank
	private String detalle;
	
	
	/*union con tipoHabitacion*/
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "tipohabitacion_caracthabitacion", 
        joinColumns = { @JoinColumn(name = "tipohabitacion_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "caracthabitacion_id")})
    private Set<TipoHabitacion>tipohabit;


}
