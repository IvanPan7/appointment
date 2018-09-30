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
import sv.com.appsv.models.services.IPacienteService;

@Controller
@SessionAttributes("paciente")
public class PacienteController {
	@Autowired
	private IPacienteService pacienteService;
	
	@RequestMapping(value="/pacientes", method=RequestMethod.GET)
	public String listarPacientes(Model model) {
		model.addAttribute("titulo","Listado de Pacientes");
		model.addAttribute("pacientes", pacienteService.findAll());
		return "pacientes";
	}
	
	@RequestMapping(value="/paciente")
	public String crearPaciente(Map<String, Object> model) {
		Paciente paciente = new Paciente();
		model.put("paciente", paciente);
		model.put("titulo", "Ingresando un Paciente");
		return "paciente";		
	}
	
	@RequestMapping(value="/paciente", method=RequestMethod.POST)
	public String guardar(@Valid Paciente paciente, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus) {
		if(bindingResult.hasErrors()) {
			return "paciente";
		}
		pacienteService.save(paciente);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("Success","Paciente creado exitosamente");
		return "redirect:pacientes";		
	}
	
	@RequestMapping(value="/paciente/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash){
		Paciente paciente = null;
		if(id>0) {
			paciente = pacienteService.findOne(id);
		}else {
			flash.addFlashAttribute("error", "El id del cliente no puede ser menor a cero");
			return "retirect:/paciente";
		}
		model.put("paciente", paciente);
		model.put("titulo", "Editar Paciente");
		return "paciente";		
	}
	
	@RequestMapping(value="/eliminarpaciente/{id}")
	public String eliminar(@PathVariable(value="id")Long id, RedirectAttributes flash) {
		if(id>0) {
			pacienteService.delete(id);
		}
		flash.addFlashAttribute("Success", "El paciente ha sido eliminado");
		return "redirect:/pacientes";
	}
	
}
