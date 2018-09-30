package sv.com.appsv.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List; 

import sv.com.appsv.models.dao.IConsultaDAO;
import sv.com.appsv.models.entities.Consulta;

@Service
public class ConsultaServiceImpl implements IConsultaService{
	
	@Autowired
	private IConsultaDAO consultaDAO;
	
	@Override
	@Transactional(readOnly=true)
	public List<Consulta> findAll() {
		return (List<Consulta>) consultaDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Consulta findOne(Long id) {
		return consultaDAO.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save(Consulta consulta) {
		consultaDAO.save(consulta);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		consultaDAO.deleteById(id);
	}	
}
