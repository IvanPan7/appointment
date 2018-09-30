package sv.com.appsv.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import sv.com.appsv.models.entities.Usuario;
import sv.com.appsv.models.services.IUsuarioService;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value="/usuario", method=RequestMethod.GET)
	public String listarPacientes(Model model) {
		model.addAttribute("titulo","Agregar usuario");
		return "usuario";
	}
	
	@RequestMapping(value="/usuario", method=RequestMethod.POST)
	public String guardarPaciente(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus) {
		if(bindingResult.hasErrors()) {
			return "usuario";
		}
		usuarioService.save(usuario);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("Success","Usuario creado exitosamente");
		return "redirect:/index";		
	}
	
	

}
