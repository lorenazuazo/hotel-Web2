package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name="usuariosimple")
@Data
@NoArgsConstructor @AllArgsConstructor
public class UsuarioSimple implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	protected long id;
	
	@Column(length=50)
	protected String nombre;
	
	@Column(length=50)
	protected String apellido;
	
	@Column
	@NotBlank
	@Email
	protected String correo;
	
	@PrePersist
	@PreUpdate
	protected void prepareData(){this.correo = correo == null ? null : correo.toLowerCase();}
	
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(name="usuariosimple_mensajes",
	 joinColumns=@JoinColumn(name="usuariosimple_id"),
	 inverseJoinColumns=@JoinColumn(name="mensaje_id"))
	 private Set<Mensajes> mensajeSimple;


}