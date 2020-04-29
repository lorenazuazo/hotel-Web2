package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@SuppressWarnings("serial")
@Table(name="usuario")
@Data
@NoArgsConstructor @AllArgsConstructor

public class Usuario implements Serializable {
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
	
	 @PrePersist
	 @PreUpdate
	 protected void prepareData(){this.correo = correo == null ? null : correo.toLowerCase();}

	@Column
	@NotBlank
	private String dni;
	
	@Column
	@NotBlank
	private int edad;

	@Column
	@NotBlank
	private String telefono;
	
	@Column
	@NotBlank
	private String username;
	
	@Column
	@NotBlank
	private String password;
	
	@Column
	@NotBlank
	private boolean enabled;
	
	 protected enum Genero {
			F,M
		}
	
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name="users_authorities",
	 joinColumns=@JoinColumn(name="usuario_id"),
	 inverseJoinColumns=@JoinColumn(name="authority_id"))
	 private Set<Authority> authority;
	 

	
    @OneToMany(fetch=FetchType.LAZY,mappedBy="usuario",cascade= CascadeType.ALL)
    private Set<Reservas> reservas;
	
    
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(name="users_mensajes",
	 joinColumns=@JoinColumn(name="usuario_id"),
	 inverseJoinColumns=@JoinColumn(name="mensaje_id"))
	 private Set<Mensajes> mensaje;
}
