package sv.com.appsv.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.appsv.models.dao.IUsuarioDAO;
import sv.com.appsv.models.entities.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll(){
		return (List<Usuario>) usuarioDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Usuario findOne(Long id){
		return usuarioDAO.findById(id).orElse(null);
	}
	
	
	
	
	
	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDAO.save(usuario);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDAO.deleteById(id);
	}
}
