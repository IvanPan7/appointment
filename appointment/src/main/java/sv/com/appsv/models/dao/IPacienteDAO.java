package sv.com.appsv.models.dao;

import org.springframework.data.repository.CrudRepository;
import sv.com.appsv.models.entities.Paciente;

public interface IPacienteDAO extends CrudRepository<Paciente, Long>{
	
}