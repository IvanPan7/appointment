package sv.com.appsv.models.entities;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="consultas")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "consulta_Seq")
	@SequenceGenerator(name = "consulta_Seq", sequenceName = "CONSULTA_SEQ")
	private Long id;
	
	
	
	private String dateAppointment;
	

	private String paciente_name;
	
	private String doctor_name;

	

	//Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateAppointment() {
		return dateAppointment;
	}

	public void setDateAppointment(String dateAppointment) {
		this.dateAppointment = dateAppointment;
	}

	public String getPaciente_name() {
		return paciente_name;
	}

	public void setPaciente_name(String paciente_name) {
		this.paciente_name = paciente_name;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	
	
	
	
	
	
	
	

}
