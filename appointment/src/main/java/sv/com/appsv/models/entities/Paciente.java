package sv.com.appsv.models.entities;


import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pacientes")
public class Paciente implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pacientes_Seq")
	@SequenceGenerator(name = "pacientes_Seq", sequenceName = "PACIENTES_SEQ")
	private Long id;
	private String nombres;
	private String apellidos;
	private Double edad;
	
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Double getEdad() {
		return edad;
	}

	public void setEdad(Double edad) {
		this.edad = edad;
	}
}