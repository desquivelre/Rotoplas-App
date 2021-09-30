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
import pe.edu.upc.rotoplas.entities.DetalleAlmacenID;
import pe.edu.upc.rotoplas.entities.Producto;
import pe.edu.upc.rotoplas.entities.Transferencia;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;
import pe.edu.upc.rotoplas.service.crud.DetalleAlmacenService;
import pe.edu.upc.rotoplas.service.crud.ProductoService;
import pe.edu.upc.rotoplas.service.crud.TransferenciaService;
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
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	@GetMapping("/{id_almacen_local}")
	public String Transferir(Model model, @PathVariable Integer id_almacen_local) {
		
		try {
			Optional<Almacen> almacen_local = almacenService.findById(id_almacen_local);
			if(almacen_local.isPresent()) {
				Transferencia transferencia = new Transferencia();
				
				List<DetalleAlmacen> productos = detalleAlmacenService.filterByAlmacen(id_almacen_local);
				
				
				model.addAttribute("productos", productos);
				model.addAttribute("almacen_local", almacen_local.get());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "TransferirStock.html";
	}
	
	@GetMapping("/{id_almacen_local}/transferir/{id_producto}")
	public String Transferir_Stock(Model model, @PathVariable Integer id_almacen_local, @PathVariable Integer id_producto) {
		try {
			Optional<Almacen> almacen_local = almacenService.findById(id_almacen_local);
			Optional<Producto> producto = productoService.findById(id_producto);
			
			List<DetalleAlmacen> listaproducto_trasnferir = detalleAlmacenService.filterByAlmacenProducto(id_almacen_local, id_producto);
			DetalleAlmacen producto_transferir = listaproducto_trasnferir.get(0);
			
			if(producto.isPresent()) {
				Transferencia transferencia = new Transferencia();
				List<Transferencia> transferencias = transferenciaService.getAll();
				
				transferencia.setCTransferencia(transferencias.size() + 1); //SIZE GOD
				
				transferencia.setAlmacen_local(almacen_local.get());
				transferencia.setProducto(producto.get());
				
				List<Almacen> almacenes = almacenService.getAll();
				
				model.addAttribute("transferencia", transferencia);
				model.addAttribute("almacenes", almacenes);
				model.addAttribute("producto_transferir", producto_transferir);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "TransferirStockForm.html";
	}
	
	@PostMapping("transferir_stock")
	public String Guardar_trasnferencia(Model model, @ModelAttribute("transferencia") Transferencia transferencia) {
		try {
			List<DetalleAlmacen> detalle_local = detalleAlmacenService.filterByAlmacenProducto(transferencia.getAlmacen_local().getCAlmacen(), transferencia.getProducto().getCproducto());
			List<DetalleAlmacen> detalle_destino = detalleAlmacenService.filterByAlmacenProducto(transferencia.getAlmacen_destino().getCAlmacen(), transferencia.getProducto().getCproducto());
			
			List<DetalleAlmacen> detalles_totales = detalleAlmacenService.getAll();
			
			if(detalle_destino.isEmpty()) {
				DetalleAlmacen nuevo_detalle_destino = new DetalleAlmacen();
				nuevo_detalle_destino.setAlmacen(transferencia.getAlmacen_destino());
				nuevo_detalle_destino.setProducto(transferencia.getProducto());
				nuevo_detalle_destino.setStockProducto(transferencia.getCantidad());
				
				DetalleAlmacen detalle_local_2 = detalle_local.get(0);
				detalle_local_2.setStockProducto(detalle_local_2.getStockProducto() - transferencia.getCantidad());
				
				
				DetalleAlmacen detalle_local_return = detalleAlmacenService.update(detalle_local_2);
				DetalleAlmacen nuevo_detalle_return = detalleAlmacenService.create(nuevo_detalle_destino);
				
				
			}
			else {
				
				DetalleAlmacen detalle_destino_2 = detalle_destino.get(0);
				DetalleAlmacen detalle_local_2 = detalle_local.get(0);
				
				detalle_local_2.setStockProducto(detalle_local_2.getStockProducto() - transferencia.getCantidad());
				detalle_destino_2.setStockProducto(detalle_destino_2.getStockProducto() + transferencia.getCantidad());
				
				DetalleAlmacen detalle_local_return = detalleAlmacenService.update(detalle_local_2);
				DetalleAlmacen detalle_destino_return = detalleAlmacenService.update(detalle_destino_2);
			}
			
			
			Transferencia transferencia_return = transferenciaService.create(transferencia);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(transferencia.getCTransferencia());
		System.out.println(transferencia.getAlmacen_destino().getDistrito().getNDistrito());
		System.out.println(transferencia.getAlmacen_local().getDistrito().getNDistrito());
		System.out.println(transferencia.getProducto().getCproducto());
		System.out.println(transferencia.getCantidad());
		
		return "redirect:/transferir/" + transferencia.getAlmacen_local().getCAlmacen();
	}
	
}
