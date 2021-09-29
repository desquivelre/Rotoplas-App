package pe.edu.upc.rotoplas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.rotoplas.entities.Almacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.Producto;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;
import pe.edu.upc.rotoplas.service.crud.DetalleAlmacenService;
import pe.edu.upc.rotoplas.service.crud.ProductoService;

@Controller
@RequestMapping("/modificar")
public class ModificarStockController {
	
	@Autowired
	private AlmacenService almacenService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private DetalleAlmacenService detallealmacenService;
	

	
	@GetMapping("/{id_Almacen}")
	public String ListarProducto(Model model, @PathVariable Integer id_Almacen) {
		try {
			Optional<Almacen> almacen_encontrado = almacenService.findById(id_Almacen);
			List<DetalleAlmacen> productos = detallealmacenService.filterByAlmacen(id_Almacen);
			
			model.addAttribute("productos", productos);
			model.addAttribute("almacen", almacen_encontrado.get());	
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "modificarStock.html";
	}
	
	@GetMapping("/producto/{id_producto}")
	public String ModificarProducto(Model model, @PathVariable Integer id_Producto) {
		try {
			Optional<Producto> productoModificar = productoService.findById(id_Producto);

			
			model.addAttribute("productoModificar", productoModificar.get());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "modificarStock.html";
	}
	
}
