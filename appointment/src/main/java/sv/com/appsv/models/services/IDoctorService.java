package sv.com.appsv.models.services;


import java.util.List;
import sv.com.appsv.models.entities.Doctor;

public interface IDoctorService {
	public List<Doctor> findAll();
	public void save(Doctor doctor);
	public Doctor findOne(Long id);
	public void delete(Long id);
}





