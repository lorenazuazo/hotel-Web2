package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SuppressWarnings("serial")
@Table(name="reservas")
@Data @AllArgsConstructor @NoArgsConstructor

public class Reservas  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column
	private long idReserva;
	
	@Column
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Calendar fechaEntrada;
	
	@Column
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Calendar fechaSalida;
	
	@Column
	@NotBlank
	private int cantHuesped;
	
	@Column(precision=10, scale=2)
	@NotBlank
	private float tarifaReserva;
	
	@Column(precision=10, scale=2)
	@NotBlank
	private float pagoEntrega;
	
	@Column(precision=10, scale=2)
	@NotBlank
	private float gastoAdicional;
	
	@Column(precision=10, scale=2)
	@NotBlank
	private float gastoTotal;
	
	@Column
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Calendar fechaPagoReserva;
	
	@Column
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Calendar fechaPagoTotal;
	
	@Column
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Estado estadoReserva;
	
	
	@Column(length=16)
	@NotBlank
	private String clave;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	/*union con huesped para el grupo del huesped que hace la reserva*/
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "reserva_huespedprincipal", 
        joinColumns = {@JoinColumn(name = "reserva_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "huesped_id")})
    private Set<Huesped>huespedPrincipal;
    
    /*union con huesped para el grupo del huesped que hace la reserva*/
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "reserva_grupohuesped", 
        joinColumns = { @JoinColumn(name = "reserva_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "huesped_id")})
    private Set<Huesped>huespedGrupo;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idUsuario")
    private Usuario usuario ;
    

	
	private enum Estado {
		ACTIVA, PAUSADA, CANCELADA
	}

}
