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
import pe.edu.upc.rotoplas.entities.Categoria;
import pe.edu.upc.rotoplas.entities.Color;
import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;
import pe.edu.upc.rotoplas.service.crud.CategoriaService;
import pe.edu.upc.rotoplas.service.crud.ColorService;
import pe.edu.upc.rotoplas.service.crud.DetalleAlmacenService;
import pe.edu.upc.rotoplas.service.crud.RegisterService;

@Controller
@RequestMapping("/listarproductos")
public class ListarProductoController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	private DetalleAlmacenService detallealmacenService;
	
	@Autowired
	private AlmacenService almacenService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ColorService colorService;
	
	
	@GetMapping("{id_almacen}")
	public String responseListarProductos(Model model, @PathVariable("id_almacen") Integer id_almacen) {
		
		try {
			Optional<Almacen> almacen_encontrado = almacenService.findById(id_almacen);
			List<DetalleAlmacen> productos = detallealmacenService.filterByAlmacen(id_almacen);
			
			List<Categoria> categorias = categoriaService.getAll();
			List<Color> colores = colorService.getAll();
			
			model.addAttribute("productos", productos);
			model.addAttribute("categorias", categorias);
			model.addAttribute("almacen", almacen_encontrado.get());	
			model.addAttribute("colores", colores);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return "listarProductos.html";
	}
	
	@GetMapping("{idalmacen}/categoria/{idcategoria}")
	public String responseListarPorCategoria(Model model, @PathVariable("idcategoria") Integer idcategoria, @PathVariable("idalmacen") Integer idalmacen) {	
		try {
			List<DetalleAlmacen> productos = detallealmacenService.filterByAlmacenCategoria(idalmacen, idcategoria);
			Optional<Almacen> almacen = almacenService.findById(idalmacen);
			List<Categoria> categorias = categoriaService.getAll();
			List<Color> colores = colorService.getAll();
			
			model.addAttribute("productos", productos);
			model.addAttribute("almacen", almacen.get());
			model.addAttribute("categorias", categorias);
			model.addAttribute("colores", colores);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return "listarProductosPorCategoria.html";
	}
	
	@GetMapping("{idalmacen}/color/{idcolor}")
	public String responseListarPorColor(Model model, @PathVariable("idcolor") Integer idcolor, @PathVariable("idalmacen") Integer idalmacen) {	
		try {
			List<DetalleAlmacen> productos = detallealmacenService.filterByAlmacenColor(idalmacen, idcolor);
			Optional<Almacen> almacen = almacenService.findById(idalmacen);
			List<Categoria> categorias = categoriaService.getAll();
			List<Color> colores = colorService.getAll();
			
			model.addAttribute("productos", productos);
			model.addAttribute("almacen", almacen.get());
			model.addAttribute("categorias", categorias);
			model.addAttribute("colores", colores);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return "listarProductosPorCategoria.html";
	}
	
	
	
}
