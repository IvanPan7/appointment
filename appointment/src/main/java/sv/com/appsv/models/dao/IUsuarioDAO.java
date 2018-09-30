package sv.com.appsv.models.dao;
import org.springframework.data.repository.CrudRepository;

import sv.com.appsv.models.entities.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{

}
