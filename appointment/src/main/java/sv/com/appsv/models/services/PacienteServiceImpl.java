package sv.com.appsv.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sv.com.appsv.models.dao.IPacienteDAO;
import sv.com.appsv.models.entities.Paciente;


@Component("pacienteService")
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteDAO pacienteDao;

	@Override
	@Transactional(readOnly=true)
	public List<Paciente> findAll() {
		return (List<Paciente>)pacienteDao.findAll();
	}

	@Override
	@Transactional()
	public void save(Paciente paciente) {
		pacienteDao.save(paciente);		
	}

	@Override
	@Transactional(readOnly=true)	
	public Paciente findOne(Long id) {
		return pacienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public void delete(Long id) {
		pacienteDao.deleteById(id);		
	}
}
