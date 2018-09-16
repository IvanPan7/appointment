package sv.com.appsv.models.dao;
import org.springframework.data.repository.CrudRepository;
import sv.com.appsv.models.entities.Paciente;

public interface IPacienteDAO {
	public interface IPacienteDao extends CrudRepository<Paciente, Long> {}
}