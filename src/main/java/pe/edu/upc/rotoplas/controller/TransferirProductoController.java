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
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;
import pe.edu.upc.rotoplas.service.crud.DetalleAlmacenService;
import pe.edu.upc.rotoplas.service.crud.ProductoService;
import pe.edu.upc.rotoplas.service.crud.UsuarioService;

@Controller
@RequestMapping("/transferir")
public class TransferirProductoController {

	@Autowired
	private AlmacenService almacenService;
	
	@Autowired
	private DetalleAlmacenService detalleAlmacenService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("{id_almacen}/{id_usuario}/{id_almacen_receptor}")
	public String Transferir(Model model, @PathVariable Integer id_almacen, @PathVariable Integer id_usuario) {
		
		try {
			Optional<Almacen> almacen_encontrado = almacenService.findById(id_almacen);
			Optional<Usuario> usuario_encontrado = usuarioService.findById(id_usuario);
			Almacen almacen_receptor = new Almacen();
			
			if(almacen_encontrado.isPresent()) {
				model.addAttribute("almacen", almacen_encontrado.get());
				model.addAttribute("usuario", usuario_encontrado);
				model.addAttribute("almacen_receptor", almacen_receptor);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	@PostMapping("realizar_transferencia/{id_almacen_receptor}/{id_almacen_local}/{id_producto}/{cantidad}")
	public String Realizar_Transferencia(Model model, @ModelAttribute("almacen") Almacen almacen, 
										 @ModelAttribute("almacen_receptor") Almacen almacen_receptor,
			   							 @PathVariable Integer id_almacen_receptor,
										 @PathVariable Integer id_producto, @PathVariable Integer cantidad,
										 @PathVariable Integer id_almacen_local) {
		try {
		//	Optional<Almacen> almacen_receptor = almacenService.findById(id_almacen_receptor);
			Optional<Almacen> almacen_local = almacenService.findById(id_almacen_local);
			Optional<Producto> producto_encontrado = productoService.findById(id_producto);
								
					
			Optional<DetalleAlmacen> detalle_receptor = detalleAlmacenService.findById(new DetalleAlmacenID(producto_encontrado.get().getCproducto(), almacen_receptor.getCAlmacen()));
			Optional<DetalleAlmacen> detalle_local = detalleAlmacenService.findById(new DetalleAlmacenID(producto_encontrado.get().getCproducto(), almacen_local.get().getCAlmacen()));
			
			if(detalle_receptor.isPresent()) {
				//Si el producto existe en el almacen a recibir, se cambian las cantidades
				detalle_local.get().setStockProducto(detalle_local.get().getStockProducto() -  cantidad);
				detalle_receptor.get().setStockProducto(detalle_receptor.get().getStockProducto() + cantidad);
				
				
				DetalleAlmacen detalle_actualizado_local = detalle_local.get();
				DetalleAlmacen detalle_return = detalleAlmacenService.update(detalle_actualizado_local);
			}
			else {
				//Si el almacén receptor no tiene ese producto, primero se añadirá ese producto en ese almacén con con la cantidad incial 
				DetalleAlmacen nuevo_detalle = new DetalleAlmacen();
				nuevo_detalle.setAlmacen(almacen_receptor);
				nuevo_detalle.setProducto(producto_encontrado.get());
				nuevo_detalle.setStockProducto(cantidad);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
	
}
