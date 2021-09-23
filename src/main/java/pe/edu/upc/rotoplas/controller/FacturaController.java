package pe.edu.upc.rotoplas.controller;


import java.util.Date;
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

import pe.edu.upc.rotoplas.entities.Cartera;
import pe.edu.upc.rotoplas.entities.Operacion;
import pe.edu.upc.rotoplas.service.crud.CarteraService;
import pe.edu.upc.rotoplas.service.crud.OperacionService;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	
	@Autowired
	private CarteraService carteraService;
	
	@Autowired
	private OperacionService operacionService;
	
	@GetMapping("{id}") 
	public String response(Model model, @PathVariable Integer id) {
		try {
			Optional<Cartera> cartera = carteraService.findById(id);
			if(cartera.isPresent()) {
						
				Operacion operacion = new Operacion();
				List<Operacion> numoperacion = operacionService.getAll();
				
				operacion.setCOperacion(numoperacion.size()+1);
				operacion.setCartera(cartera.get());
				
				
				
				model.addAttribute("cartera", cartera.get());
				model.addAttribute("newFactura", operacion);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/nuevaFactura.html";
	 }
	
	@PostMapping("crearfactura")
	public String CrearFactura(@ModelAttribute("newFactura") Operacion operacion) {
		try {
			
			if(operacion.getCartera().getTasa().getCTasa()==1) {
 
				operacion.setTCEA(pe.edu.upc.rotoplas.controller.CalculoController.TCEAParaTasaNominal(operacion.getCartera().getPerTasaNominal(), operacion.getCartera().getNumDiasTasa(), operacion.getCartera().getNumDiasPeriodoCapitalizacion(), operacion.getDPago(), operacion.getCartera().getDDescuento(), operacion.getValorNominal(), operacion.getCartera().getGastoInicialTotal(), operacion.getCartera().getGastoFinalTotal(), operacion.getRetencion()));	
				operacion.setValorRecibido(pe.edu.upc.rotoplas.controller.CalculoController.ValorRecibidoParaTasaNominal(operacion.getCartera().getPerTasaNominal(), operacion.getCartera().getNumDiasTasa(), operacion.getCartera().getNumDiasPeriodoCapitalizacion(), operacion.getDPago(), operacion.getCartera().getDDescuento(), operacion.getValorNominal(), operacion.getCartera().getGastoInicialTotal(), operacion.getCartera().getGastoFinalTotal(), operacion.getRetencion()));
			}
			if(operacion.getCartera().getTasa().getCTasa()==2) {
				 
				operacion.setTCEA(pe.edu.upc.rotoplas.controller.CalculoController.TCEAParaTasaEfectiva(operacion.getCartera().getPerTasaEfectiva(), operacion.getCartera().getNumDiasTasa(), operacion.getDPago(), operacion.getCartera().getDDescuento(), operacion.getValorNominal(), operacion.getCartera().getGastoInicialTotal(), operacion.getCartera().getGastoFinalTotal(), operacion.getRetencion()));	
				operacion.setValorRecibido(pe.edu.upc.rotoplas.controller.CalculoController.ValorRecibidoParaTasaEfectiva(operacion.getCartera().getPerTasaNominal(), operacion.getCartera().getNumDiasTasa(), operacion.getDPago(), operacion.getCartera().getDDescuento(), operacion.getValorNominal(), operacion.getCartera().getGastoInicialTotal(), operacion.getCartera().getGastoFinalTotal(), operacion.getRetencion()));

			}
			
			double scale = Math.pow(10, 2);
			
			double valor = operacion.getCartera().getValorRecibidoTotal()+operacion.getValorRecibido();
			valor=Math.round(valor* scale) / scale;
			
            operacion.getCartera().setTCEATotal(operacion.getCartera().getTCEATotal()+operacion.getTCEA());
            operacion.getCartera().setValorRecibidoTotal(valor);
                
            
            
            Operacion operacionReturn = operacionService.create(operacion);
            
							
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/cartera/" + operacion.getCartera().getCCartera();
	}
	
	
	
	
	
}

