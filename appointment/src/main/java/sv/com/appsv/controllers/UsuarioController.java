package sv.com.appsv.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.appsv.models.entities.Paciente;
import sv.com.appsv.models.entities.Usuario;
import sv.com.appsv.models.services.IUsuarioService;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value="/usuarios", method=RequestMethod.GET)
	public String listarUsuarios(Model model) {
		model.addAttribute("title","Agregar usuario");
		return "usuario";
	}
	
	@RequestMapping(value="/usuario")
	public String crearUsuario(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("title", "Agregar usuario");
		return "usuario";
	}
	
	@RequestMapping(value="/usuario", method=RequestMethod.POST)
	public String guardarUsuario(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus) {
		if(bindingResult.hasErrors()) {
			return "usuario";
			
		}
		usuarioService.save(usuario);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("Success", "Usuario creado exitosamente");
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/usuario/{id}")
	public String editarUsuario(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash){
		Usuario usuario= null;
		if(id>0) {
			usuario = usuarioService.findOne(id);
		}else {
			flash.addFlashAttribute("error", "El id del usuario no puede ser menor a cero");
			return "redirect:/usuario";
		}
		model.put("usuario", usuario);
		model.put("titulo", "Editar Usuario");
		return "usuario";		
	}
	
	@RequestMapping(value="/eliminarusuario/{id}")
	public String eliminarUsuario(@PathVariable(value="id")Long id, RedirectAttributes flash) {
		if(id>0) {
			usuarioService.delete(id);
		}
		flash.addFlashAttribute("Success", "El usuario ha sido eliminado");
		return "redirect:/";
	}
	

}
