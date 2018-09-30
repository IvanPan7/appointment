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

import sv.com.appsv.models.entities.Consulta;
import sv.com.appsv.models.services.IConsultaService;

@Controller
@SessionAttributes("consulta")
public class ConsultaController {
	@Autowired
	private IConsultaService consultaService;
	
	@RequestMapping(value="/consultas", method=RequestMethod.GET)
	public String listarConsultas(Model model) {
		model.addAttribute("titulo", "Listado de Consultas");
		model.addAttribute("consultas", consultaService.findAll());
		return "consultas";
	}
	
	@RequestMapping(value="/consulta")
	public String crearConsulta(Map<String, Object>model) {
		Consulta consulta = new Consulta();
		model.put("consulta", consulta);
		model.put("titulo", "Ingresando una consulta");		
		return "consulta";
	}
	
	@RequestMapping(value="/consulta", method=RequestMethod.POST)
	public String guardarConsulta(@Valid Consulta consulta, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus) {
		if(bindingResult.hasErrors()) {
			return "consulta";
		}
		consultaService.save(consulta);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("Success", "Consulta creada exitosamente");
		return "redirect:consultas";
	}
	
	@RequestMapping(value="/consulta/{id}")
	public String editarConsulta(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Consulta consulta = null;
		if(id>0) {
			consulta = consultaService.findOne(id);
		}else {
			flash.addFlashAttribute("error", "El id de la consulta no puede ser menor a cero");
			return "redirect:/consulta";
		}
		model.put("consulta", consulta);
		model.put("titulo", "Editar Consulta");
		return "consulta";
	}
	
	@RequestMapping(value="/eliminarconsulta/{id}")
	public String eliminarConsulta(@PathVariable(value="id")Long id, RedirectAttributes flash) {
		if(id>0) {
			consultaService.delete(id);
		}
		flash.addFlashAttribute("Success", "La consulta ha sido eliminado");
		return "redirect:/consultas";
	}
	
}
