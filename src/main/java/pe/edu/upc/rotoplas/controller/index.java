package pe.edu.upc.rotoplas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.RegisterService;

@Controller
@RequestMapping("/")
public class index {
	@GetMapping("login")
	public String login() {
		return "login.html";
	}
	
	@Autowired
	private RegisterService registerService ;
	
	@GetMapping()
	public String response(Model model) {
		
		return "/menu.html";
	}
	
	
}
