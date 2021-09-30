package pe.edu.upc.rotoplas.controller;

import java.awt.Color;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.rotoplas.entities.Almacen;
import pe.edu.upc.rotoplas.entities.Categoria;
import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacenID;
import pe.edu.upc.rotoplas.entities.Producto;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;
import pe.edu.upc.rotoplas.service.crud.CategoriaService;
import pe.edu.upc.rotoplas.service.crud.ColorService;
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
	private CategoriaService categoriaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ColorService colorService;
	
	@GetMapping("/{id_Almacen}/{id_usuario}")
	public String Crear_Producto(Model model, @PathVariable Integer id_Almacen, @PathVariable Integer id_usuario) {
		try {
			Optional<Almacen> almacen_encontrado = almacenService.findById(id_Almacen);
			Optional<Usuario> usuario_encontrado = usuarioService.findById(id_usuario);
			
			if(almacen_encontrado.isPresent()) {
				Producto producto = new Producto();
				DetalleAlmacen detalle = new DetalleAlmacen();
				
				List<Producto> productos = productoService.getAll();
				List<Categoria> categorias = categoriaService.getAll();
				List<pe.edu.upc.rotoplas.entities.Color> colores = colorService.getAll();
				
				producto.setCproducto(productos.size()+1);
				producto.setNproducto("");
				
				
				DetalleAlmacenID detalle_id = new DetalleAlmacenID();
						
				detalle.setAlmacen(almacen_encontrado.get());
				detalle.setProducto(producto);
				
				detalle_id.setAlmacen(detalle.getAlmacen().getCAlmacen());
				detalle_id.setProducto(detalle.getProducto().getCproducto());
				
				model.addAttribute("nuevo_producto", producto);
				model.addAttribute("almacen", almacen_encontrado.get());
				model.addAttribute("nuevo_detalle", detalle);
				model.addAttribute("usuario", usuario_encontrado);
				model.addAttribute("categorias", categorias);
				model.addAttribute("colores", colores);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "registrarProducto.html";
	}
	


	
	@PostMapping("/{id_Almacen}/{id_usuario}")
	public String Guardar_Producto(@Valid @ModelAttribute Producto producto,BindingResult result , @ModelAttribute DetalleAlmacen detalleAlmacen,BindingResult result2,Almacen almacen,  Model model,String error) {
	
		if(result.hasErrors() || result2.hasErrors()) {
			System.out.println("Existen errores");
			return "redirect:/crear/{id_Almacen}/{id_usuario}";
		}else {
			  
			  model.addAttribute("producto",productoService.registrar(producto));
			  model.addAttribute("detalleAlmacen",detalleAlmacenService.registrar(detalleAlmacen));
			  
		System.out.println(producto.getCproducto());
		System.out.println(producto.getCategoria().getNcategoria());
		System.out.println(producto.getColor().getNcolores());
		   System.out.println("Creado Correctamente");
		
		return "redirect:/seleccionAlmacen/" + almacen.getCAlmacen();	
		}
	
	}
}
