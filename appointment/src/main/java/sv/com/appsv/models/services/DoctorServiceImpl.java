package sv.com.appsv.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List; 


import sv.com.appsv.models.dao.IDoctorDAO;
import sv.com.appsv.models.entities.Doctor;


@Service
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	private IDoctorDAO doctorDAO;
	
	@Override
	@Transactional(readOnly=true)
	public List<Doctor> findAll() {
		return (List<Doctor>) doctorDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Doctor findOne(Long id) {
		return doctorDAO.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save(Doctor doctor) {
		doctorDAO.save(doctor);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		doctorDAO.deleteById(id);
	}
	
}
