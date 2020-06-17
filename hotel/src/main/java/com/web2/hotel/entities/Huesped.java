package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SuppressWarnings("serial")
@Table(name="huesped")
@AllArgsConstructor @NoArgsConstructor
@Data
public class Huesped implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	protected long id;
	
	@Column(length=50)
	@NotBlank
	protected String nombre;
	
	@Column(length=50)
	@NotBlank
	protected String apellido;
	
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	protected Genero sexo;		

	@Column
	@NotBlank
	@Email
	protected String correo;
	
	@PrePersist//para que lleve a minisculas //
    @PreUpdate	 
    protected void prepareData(){this.correo = correo == null ? null : correo.toLowerCase();}
	
	@Column
	@NotBlank
	private String dni;
	
	@Column
	@NotNull
	private int edad;

	@Column
	@NotBlank
	private String telefono;
	
	 protected enum Genero {
			F,M
		}
	
    
    /*union con reserva para el grupo del huesped que hace la reserva*/
    @ManyToMany(mappedBy="huespedGrupo")
    private Set<Reservas> reserva;
    
    
    /*union con Servicio*/
    @ManyToMany(mappedBy="huespedServicio")
    private Set<Servicios>servicio;
    
    
}
