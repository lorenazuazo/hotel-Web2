package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SuppressWarnings("serial")
@Table(name="mensajes")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Mensajes implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;
	
	@Column
	@NotBlank
	protected String nombre;
	
	@Column
	@NotBlank
	protected String apellido;
	
	@Column
	@NotBlank
	@Email
	protected String correo;
	
	@Column
	@NotBlank
	protected String mensaje;
	
	@PrePersist
	@PreUpdate
	protected void prepareData(){
		this.correo = correo == null ? null : correo.toLowerCase();
		this.mensaje= mensaje== null ? null : mensaje.toLowerCase();
		}
	
	@ManyToMany(mappedBy="mensaje")
	private Set<Usuario>usuario;

}
