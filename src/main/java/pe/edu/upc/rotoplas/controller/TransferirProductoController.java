package pe.edu.upc.rotoplas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.rotoplas.entities.Almacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacenID;
import pe.edu.upc.rotoplas.entities.Producto;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;
import pe.edu.upc.rotoplas.service.crud.DetalleAlmacenService;
import pe.edu.upc.rotoplas.service.crud.ProductoService;

@Controller
@RequestMapping("/transferir")
public class TransferirProductoController {

	@Autowired
	private AlmacenService almacenService;
	
	@Autowired
	private DetalleAlmacenService detalleAlmacenService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("{id_almacen}")
	public String Transferir(Model model, @PathVariable Integer id_almacen) {
		
		try {
			Optional<Almacen> almacen_encontrado = almacenService.findById(id_almacen);
			
			if(almacen_encontrado.isPresent()) {
				model.addAttribute("almacen", almacen_encontrado.get());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	@PostMapping("realizar_transferencia/{id_almacen_receptor}/{id_producto}")
	public String Realizar_Transferencia(Model model, @ModelAttribute("almacen") Almacen almacen, @PathVariable Integer id_almacen_receptor,
										 @PathVariable Integer id_producto) {
		try {
			Optional<Almacen> almacen_receptor = almacenService.findById(id_almacen_receptor);
			Optional<Producto> producto_encontrado = productoService.findById(id_producto);
								
					
			Optional<DetalleAlmacen> detalle = detalleAlmacenService.findById(new DetalleAlmacenID(producto_encontrado.get().getCproducto(), almacen_receptor.get().getCAlmacen()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
	
}
