package sv.com.appsv.models.services;

import java.util.List;
import sv.com.appsv.models.entities.Consulta;


public interface IConsultaService {
	public List<Consulta> findAll();
	public void save(Consulta consulta);
	public Consulta findOne(Long id);
	public void delete(Long id);
}
