package pe.edu.upc.rotoplas.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.rotoplas.entities.Almacen;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;
import pe.edu.upc.rotoplas.service.crud.RegisterService;

@Controller
@RequestMapping("/seleccionAlmacen")
public class MenuController {	

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private AlmacenService almacenService;
	
	@GetMapping
	public String response(Model model) {
		List<Almacen> lista_almacenes;
		try {
			lista_almacenes = almacenService.getAll();
			model.addAttribute("almacenes", lista_almacenes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "/seleccionAlmacen.html";
	}
	
	@GetMapping("{id_almacen}")
	public String enviarCodigoAlmacen(Model model, @PathVariable("id_almacen") Integer id_almacen) {
		try {
			Optional<Almacen> almacenenviar = almacenService.findById(id_almacen);
			model.addAttribute("almacenenviar", almacenenviar.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "/menuControlInventario.html";
	}
	

}
