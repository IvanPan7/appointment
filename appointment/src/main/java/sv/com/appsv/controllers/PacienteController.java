package sv.com.appsv.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.appsv.models.entities.Paciente;
import sv.com.appsv.models.services.IPacienteService;


@Controller
public class PacienteController {

	@Autowired
	@Qualifier("pacienteService")
	private IPacienteService pacienteService;
	
	@RequestMapping(value="/pacientes" ,method=RequestMethod.GET)
	public String list(Model model) {

		model.addAttribute("title", "Pacientes");
		model.addAttribute("pacientes", pacienteService.findAll());
		return "pacientes";
	}
	
	@RequestMapping(value="/paciente")
	public String crear(Map<String, Object> model) {
		Paciente paciente = new Paciente();
		model.put("paciente", paciente);
		model.put("title", "Formulario de Pacientes");
		return "paciente";
	}
	
	@RequestMapping(value="/paciente", method=RequestMethod.POST)
	public String guardar(@Valid Paciente paciente, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "pacientes";
		}
		
		pacienteService.save(paciente);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Paciente creado con exito");
		return "redirect:pacientes";
	}
	
	
	@RequestMapping(value="/paciente/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Paciente paciente = null;
		if (id > 0) {
			paciente = pacienteService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del paciente no puede ser cero");
			return "redirect:/pacientes";
		}
		model.put("paciente", paciente);
		model.put("title", "Editar paciente");
		
		return "paciente";
	}
	
	@RequestMapping(value="/remove/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			pacienteService.delete(id);
		}
		flash.addFlashAttribute("success","paciente eliminado con exito");
		return "redirect:/pacientes";
	}
	
	@RequestMapping(value="/pacientes/regresar/")
	public String regresar() {
		return "redirect:/pacientes";
	}
}