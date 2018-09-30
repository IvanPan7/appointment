package sv.com.appsv.models.services;

import java.util.List;
import sv.com.appsv.models.entities.Paciente;

public interface IPacienteService {
	public List<Paciente> findAll();
	public void save(Paciente paciente);
	public Paciente findOne(Long id);
	public void delete(Long id);
}
