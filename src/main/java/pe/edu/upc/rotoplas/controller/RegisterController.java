package pe.edu.upc.rotoplas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	
	@GetMapping("/auth/registro")
	public String registroForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "loginvista";
	}
	
	@PostMapping("/auth/registro")
    public String registro(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
    if(result.hasErrors()) {

        System.out.println("Existen errores");

        return "loginvista";
    }else {
        model.addAttribute("usuario",registerService.registrar(usuario));
        System.out.println("Creado Correctamente");
    }
    return "redirect:/login";
}

}