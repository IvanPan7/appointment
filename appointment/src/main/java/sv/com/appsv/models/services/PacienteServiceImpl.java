package sv.com.appsv.models.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List; 

import sv.com.appsv.models.dao.IPacienteDAO;
import sv.com.appsv.models.entities.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService{
	@Autowired
	private IPacienteDAO pacienteDAO;
	
	@Override
	@Transactional(readOnly=true)
	public List<Paciente> findAll() {
		return (List<Paciente>) pacienteDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Paciente findOne(Long id) {
		return pacienteDAO.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save (Paciente paciente) {
		pacienteDAO.save(paciente);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		pacienteDAO.deleteById(id);
	}
	
}
