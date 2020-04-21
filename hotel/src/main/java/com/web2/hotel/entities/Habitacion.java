package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SuppressWarnings("serial")
@Table(name="habitacion")
@Data @AllArgsConstructor @NoArgsConstructor

public class Habitacion implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column
	private long id;
	
	@Column(length=16)
	@NotBlank
	private String numerohabitacion;
	

	
	/*union con TipoHabitacion*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idtipohabitacion")
    private TipoHabitacion tipoHabitacion;


    /*union con Huesped*/
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "habitacion_huesped", 
        joinColumns = { @JoinColumn(name = "habitacion_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "huesped_id")})
    private Set<Huesped>huespedHabitacion;
	
	

}
