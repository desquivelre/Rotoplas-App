package pe.edu.upc.rotoplas.controller;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.rotoplas.entities.Usuario;



@Controller
public class index {
	
	
	@GetMapping("/index")
	public String login(@RequestParam(required = false) String error ,ModelMap model	) {
		
		
		if(error!=null) {
			model.addAttribute("error","ERROR DE ACESSO: Usuario y/o contraseña incorrecto");
			
		}
	
		
		
		
		return "index";
	}
	

	

	
}
