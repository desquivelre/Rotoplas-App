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
import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.Producto;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;
import pe.edu.upc.rotoplas.service.crud.DetalleAlmacenService;
import pe.edu.upc.rotoplas.service.crud.ProductoService;
import pe.edu.upc.rotoplas.service.crud.UsuarioService;

@Controller
@RequestMapping("/crear")
public class CrearProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private AlmacenService almacenService;
	
	@Autowired
	private DetalleAlmacenService detalleAlmacenService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("{id_Almacen}/{id_usuario}")
	public String Crear_Producto(Model model, @PathVariable Integer id_Almacen, @PathVariable Integer id_usuario) {
		try {
			Optional<Almacen> almacen_encontrado = almacenService.findById(id_Almacen);
			Optional<Usuario> usuario_encontrado = usuarioService.findById(id_usuario);
			
			if(almacen_encontrado.isPresent()) {
				Producto producto = new Producto();
				DetalleAlmacen detalle = new DetalleAlmacen();
				
				detalle.setAlmacen(almacen_encontrado.get());
				detalle.setProducto(producto);
				
				model.addAttribute("nuevo_producto", producto);
				model.addAttribute("almacen", almacen_encontrado.get());
				model.addAttribute("nuevo_detalle", detalle);
				model.addAttribute("usuario", usuario_encontrado);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
	
	@PostMapping("guardar_producto")
	public String Guardar_Producto(Model model, @ModelAttribute("nuevo_producto") Producto producto, @ModelAttribute("nuevo_detalle") DetalleAlmacen detalleAlmacen) {
		try {
			Producto producto_return = productoService.create(producto);
			DetalleAlmacen detalle_return = detalleAlmacenService.create(detalleAlmacen);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
}
