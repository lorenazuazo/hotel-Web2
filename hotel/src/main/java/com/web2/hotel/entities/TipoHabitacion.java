package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@SuppressWarnings("serial")
@Table(name="Tipohabitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoHabitacion implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column
	private long id_tipo;
	
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
	
	 @OneToMany(cascade = CascadeType.ALL)
	 private Set<Habitacion> habitacion;

}
