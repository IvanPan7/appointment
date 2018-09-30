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

import sv.com.appsv.models.entities.Doctor;
import sv.com.appsv.models.services.IDoctorService;


@Controller
@SessionAttributes("doctor")
public class DoctorController {
	@Autowired
	private IDoctorService doctorService;
	
	@RequestMapping(value="/doctores", method=RequestMethod.GET)
	public String listarDoctores(Model model) {
		model.addAttribute("titulo","Listado de Doctores");
		model.addAttribute("doctores", doctorService.findAll());
		return "doctores";
	}
	
	@RequestMapping(value="/doctor")
	public String crearDoctor(Map<String, Object> model) {
		Doctor doctor= new Doctor();
		model.put("doctor", doctor);
		model.put("titulo", "Ingresando un Doctor");
		return "doctor";		
	}
	
	@RequestMapping(value="/doctor", method=RequestMethod.POST)
	public String guardarDoctor(@Valid Doctor doctor, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus) {
		if(bindingResult.hasErrors()) {
			return "doctor";
		}
		doctorService.save(doctor);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("Success","Doctor creado exitosamente");
		return "redirect:doctores";		
	}
	
	@RequestMapping(value="/doctor/{id}")
	public String editarDoctor(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash){
		Doctor doctor = null;
		if(id>0) {
			doctor = doctorService.findOne(id);
		}else {
			flash.addFlashAttribute("error", "El id del doctor no puede ser menor a cero");
			return "redirect:/doctor";
		}
		model.put("doctor", doctor);
		model.put("titulo", "Editar Doctor");
		return "doctor";		
	}
	
	@RequestMapping(value="/eliminardoctor/{id}")
	public String eliminarDoctor(@PathVariable(value="id")Long id, RedirectAttributes flash) {
		if(id>0) {
			doctorService.delete(id);
		}
		flash.addFlashAttribute("Success", "El doctor ha sido eliminado");
		return "redirect:/doctores";
	}
	
}
