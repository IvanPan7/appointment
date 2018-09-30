package sv.com.appsv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listarPacientes(Model model) {
		model.addAttribute("titulo","Listado de Pacientes");
		return "index";
	}
}
