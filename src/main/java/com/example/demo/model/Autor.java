package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Autor implements Serializable {
	@Getter
	@Setter
	@Id
	@NotNull
	private String dni;
	@Getter
	@Setter
	@NotNull
	private String nombre;
	@Getter
	@Setter
	@NotNull
	private String apellido1;
	@Getter
	@Setter
	private String apellido2;
	@Getter
	@Setter
	private String telefono;
	@Getter
	@Setter
	private String email;
}
