package sv.com.appsv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String listarPacientes(Model model) {
		model.addAttribute("title","Acerca de nuestra clinica");
		return "about";
	}
}
