package com.web2.hotel.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="newsletters")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Newsletters {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	protected long id;
	
	@Column
	@NotBlank
	@Email
	protected String correo;
	
	@PrePersist
	@PreUpdate
	protected void prepareData(){this.correo = correo == null ? null : correo.toLowerCase();}

}
