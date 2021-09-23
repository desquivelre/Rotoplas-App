package pe.edu.upc.rotoplas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.rotoplas.entities.Cartera;
import pe.edu.upc.rotoplas.entities.Operacion;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.CarteraService;
import pe.edu.upc.rotoplas.service.crud.OperacionService;

@Controller
@RequestMapping("/cartera")
public class CarteraController {
	
	@Autowired
	private OperacionService operacionService;
	
	@Autowired
	private CarteraService carteraService;
	
	@GetMapping("{id}")
	public String response(Model model, @PathVariable Integer id) {
		try {
			Optional<Cartera> cartera = carteraService.findById(id);
			
			if(cartera.isPresent()) {
				
				List<Operacion> operaciones  = operacionService.filterOperacionesByIdCartera(cartera.get().getCCartera());
				model.addAttribute("operaciones", operaciones);
				model.addAttribute("cartera", cartera.get());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/Carteradefacturas.html";
		
	}
}
