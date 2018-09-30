package sv.com.appsv.models.dao;

import org.springframework.data.repository.CrudRepository;
import sv.com.appsv.models.entities.Doctor;

public interface IDoctorDAO extends CrudRepository<Doctor, Long> {

}
