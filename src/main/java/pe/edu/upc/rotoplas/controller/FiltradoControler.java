package pe.edu.upc.rotoplas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filtrado")
public class FiltradoControler {
	@GetMapping
	public String response() {
		return "/FiltradodeCarteradefacturas.html";
	}
}
