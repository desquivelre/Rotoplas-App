package pe.edu.upc.rotoplas.controller;

import java.util.List;
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
import pe.edu.upc.rotoplas.entities.Categoria;
import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.Producto;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;
import pe.edu.upc.rotoplas.service.crud.CategoriaService;
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
	
	@Autowired
	private CategoriaService categoriaService;

	
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
	
	@GetMapping("{id_Almacen}/producto/{id_producto}")
	public String ModificarProducto(Model model, @PathVariable("id_Almacen") Integer id_Almacen, @PathVariable("id_producto") Integer id_Producto) {
		try {
			Optional<Almacen> almacenSeleccion = almacenService.findById(id_Almacen);
			Optional<Producto> producto = productoService.findById(id_Producto);
			List<DetalleAlmacen> listaproductoalmacenmodificar = detallealmacenService.filterByAlmacenProducto(id_Almacen, id_Producto);
			
			DetalleAlmacen productoalmacenmodificar = listaproductoalmacenmodificar.get(0);
			
			if (producto.isPresent()) {
				Optional<Producto> productoModificar = productoService.findById(id_Producto);
				
				model.addAttribute("productoModificar", productoModificar.get());
				model.addAttribute("almacenSeleccion", almacenSeleccion.get());
				model.addAttribute("productoalmacenmodificar", productoalmacenmodificar);
				
				return "modificarStockForm.html";
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "modificarStock.html";
	}
	
	@PostMapping("modificarproducto")
	public String Guardar_Producto(Model model, @ModelAttribute("productoalmacenmodificar") DetalleAlmacen productoalmacenmodificar) {
		try {
			
			DetalleAlmacen productoReturn = detallealmacenService.update(productoalmacenmodificar);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:/modificar/"+productoalmacenmodificar.getAlmacen().getCAlmacen();
	}
	
	
}
