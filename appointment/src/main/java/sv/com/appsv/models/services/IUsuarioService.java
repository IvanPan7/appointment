package sv.com.appsv.models.services;

import java.util.List;

import sv.com.appsv.models.entities.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	public void save(Usuario usuario);
	public Usuario findOne(Long id);
	public void delete(Long id);
}
