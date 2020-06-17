package com.web2.hotel.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor @AllArgsConstructor

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

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
	private String telefono;
	
	@Column
	@NotBlank
	private String username;
	
	@Column
	@NotBlank
	private String password;
	
	@Transient 
	private String confirmPassword;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="users_authorities",
	joinColumns=@JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="authority_id"))
	private Set<Authority> authority;
	 
	
    @OneToMany(fetch=FetchType.LAZY,mappedBy="usuario")
    private Set<Reservas> reservas;
	
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="usuario")
    private Set<Mensajes> mensaje;
}
