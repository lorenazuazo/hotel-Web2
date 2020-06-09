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

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@SuppressWarnings("serial")
@Table(name="habitacion")
@Data @AllArgsConstructor @NoArgsConstructor

public class Habitacion implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column
	private long id_habitacion;
	
	@Column
	@NotBlank
	private String numerohabitacion;
	
	@Column
	@NotNull
	private int tarifa;
	
	@Column
	@NotBlank
	private String descripcion;
	
	@Column
	@NotBlank
	private int cantidadhuesped;
	
	/*union con Tipos de habitacion*/
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne
	@JoinColumn(name="id_tipohabitacion")
	private TipoHabitacion tipoHabitacion;
    
    /*union con CaracteristicasHabitacion*/
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
        name = "habitacion_caracthabitacion", 
        joinColumns = { @JoinColumn(name = "habitacion_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "caracthabitacion_id")})
    private Set<CaracteristicasHabitacion>caractehabitacion;


    /*union con Huesped*/
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
        name = "habitacion_huesped", 
        joinColumns = { @JoinColumn(name = "habitacion_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "huesped_id")})
    private Set<Huesped>huespedHabitacion;
	
    /*union con Reservas*/
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
        name = "habitacion_reserva", 
        joinColumns = { @JoinColumn(name = "habitacion_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "reserva_id")})
    private Set<Reservas>reserva;
    

}
