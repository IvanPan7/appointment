package sv.com.appsv.models.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="pacientes")
public class Paciente{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "paciente_Seq")
	@SequenceGenerator(name = "paciente_Seq", sequenceName = "PACIENTE_SEQ")
	private Long id;

	
	private String nombres;
	
	
	private String apellidos;
	
	
	private Long edad;

	//Getters y Setters
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

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}
	
}