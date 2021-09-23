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
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.upc.rotoplas.entities.Cartera;
import pe.edu.upc.rotoplas.entities.Gasto;
import pe.edu.upc.rotoplas.entities.Tasa;
import pe.edu.upc.rotoplas.entities.TipoCalendario;
import pe.edu.upc.rotoplas.entities.TipoGasto;
import pe.edu.upc.rotoplas.entities.TipoMoneda;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.service.crud.CarteraService;
import pe.edu.upc.rotoplas.service.crud.GastoService;
import pe.edu.upc.rotoplas.service.crud.RegisterService;
import pe.edu.upc.rotoplas.service.crud.TasaService;
import pe.edu.upc.rotoplas.service.crud.TipoCalendarioService;
import pe.edu.upc.rotoplas.service.crud.TipoGastoService;
import pe.edu.upc.rotoplas.service.crud.TipoMonedaService;

@Controller
@RequestMapping("/crearcartera")
public class CrearCarteraController {
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private TasaService tasaService;
	
	@Autowired
	private TipoCalendarioService tipoCalendarioService; 
	
	@Autowired
	private TipoMonedaService tipoMonedaService; 
	
	@Autowired
	private CarteraService carteraService;
	
	@Autowired
	private TipoGastoService tipoGastoService; 
	
	@Autowired
	private GastoService gastoService;
	
	@GetMapping("{id}")
	public String response(Model model, @PathVariable Integer id) {
		try {
			List<Tasa> tasas = tasaService.getAll();
			List<TipoCalendario> calendarios = tipoCalendarioService.getAll();
			List<TipoMoneda> monedas = tipoMonedaService.getAll();
			List<Cartera> lista_carteras = carteraService.getAll();
			
			
			Cartera cartera = new Cartera();
			
			cartera.setCCartera(lista_carteras.size()+1);
			
			
			Optional<Usuario> usuario = registerService.findById(id);
			
			cartera.setUsuario(usuario.get());
			cartera.setGastoInicialTotal((float)0.0);
			cartera.setGastoFinalTotal((float)0.0);
			cartera.setTCEATotal((double)0.0);
			cartera.setValorRecibidoTotal((double)0.0);
			
			if(usuario.isPresent()) {
						
				
				
				model.addAttribute("tasas", tasas);
				model.addAttribute("calendarios", calendarios);
				model.addAttribute("monedas", monedas);
				model.addAttribute("usuario", usuario.get());
				
				model.addAttribute("new_cartera", cartera);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Datos_cartera.html";
	
	}
	
	@PostMapping("save-cartera")
	public String saveCarteraPost(Model mode, @ModelAttribute("new_cartera") Cartera cartera, @ModelAttribute("usuario") Usuario usuario) {
		
		try {
			Cartera carteraReturn = carteraService.create(cartera);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println(cartera.getCCartera());
		
		System.out.println(cartera.getUsuario().getId());
		
		System.out.println(cartera.getTipoCalendario().getTipoCalendario());
		System.out.println(cartera.getTasa().getNTasa());
		System.out.println(cartera.getPerTasaEfectiva());
		System.out.println(cartera.getPerTasaNominal());
		System.out.println(cartera.getNumDiasTasa());
		System.out.println(cartera.getNumDiasPeriodoCapitalizacion());
		System.out.println(cartera.getTipoMoneda().getNTipoMoneda());
		System.out.println(cartera.getDDescuento());
		
		
		return "redirect:/crearcartera/datosCartera/" + cartera.getUsuario().getId() + "/" + cartera.getCCartera();	
	}
	
	
	@GetMapping("datosCartera/{id}/{id_2}")
	public String viewCartera(Model model, @PathVariable("id") Integer id, @PathVariable("id_2") Integer id_2) {
		try {
			Optional<Usuario> usuario = registerService.findById(id);
			Optional<Cartera> cartera = carteraService.findById(id_2);
			
			if(usuario.isPresent()) {
				model.addAttribute("usuario", usuario.get());
				model.addAttribute("cartera", cartera.get());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Datos_cartera_2.html";
	}
	
	
	//Post y Get mapping para crear gastos iniciales
	
	@GetMapping("gastos_iniciales/{id_cartera}")
	public String crearGI(Model model, @PathVariable("id_cartera") Integer id_cartera) {
		try {
			Optional<Cartera> cartera = carteraService.findById(id_cartera);
			
			List<Gasto> gastos = gastoService.getAll();
			
			
			Gasto gasto = new Gasto();
			
			gasto.setCGasto(gastos.size()+1);
			
			gasto.setCartera(cartera.get());
			
			Optional<TipoGasto> gasto_auxiliar = tipoGastoService.findById(1);
			
			gasto.setTipoGasto(gasto_auxiliar.get());
			
						
			
			model.addAttribute("cartera", cartera);
			model.addAttribute("new_gasto_inicial", gasto);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/GastosIniciales.html";
	}
	
	@PostMapping("save_gasto_inicial")
	public String saveGastoInicial(@ModelAttribute("new_gasto_inicial") Gasto gasto_inicial) {
		
		try {
			Optional<Cartera> cartera = carteraService.findById(gasto_inicial.getCartera().getCCartera());
			cartera.get().setGastoInicialTotal(cartera.get().getGastoInicialTotal()+gasto_inicial.getMGasto());
			Gasto gastoReturn = gastoService.create(gasto_inicial);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(gasto_inicial.getCartera());
		System.out.println(gasto_inicial.getCGasto());
		System.out.println(gasto_inicial.getMGasto());
		System.out.println(gasto_inicial.getTipoGasto().getNTipoGasto());
		
		return "redirect:/crearcartera/datosCartera/" + gasto_inicial.getCartera().getUsuario().getId() + "/" + gasto_inicial.getCartera().getCCartera();
	}
	
	//Post y Get mapping para crear gastos finales
	
	@GetMapping("gastos_finales/{id_cartera}")
	public String crearGF(Model model, @PathVariable("id_cartera") Integer id_cartera) {
		try {
			Optional<Cartera> cartera = carteraService.findById(id_cartera);
			
			List<Gasto> gastos = gastoService.getAll();
			
			
			Gasto gasto = new Gasto();
			
			gasto.setCGasto(gastos.size()+1);
			
			gasto.setCartera(cartera.get());
			
			Optional<TipoGasto> gasto_auxiliar = tipoGastoService.findById(2);
			
			gasto.setTipoGasto(gasto_auxiliar.get());
			
						
			
			model.addAttribute("cartera", cartera);
			model.addAttribute("new_gasto_final", gasto);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/GastosFinales.html";
	}
	
	@PostMapping("save_gasto_final")
	public String saveGastoFinal(@ModelAttribute("new_gasto_final") Gasto gasto_final) {
		
		try {
			Optional<Cartera> cartera = carteraService.findById(gasto_final.getCartera().getCCartera());
			cartera.get().setGastoFinalTotal(cartera.get().getGastoFinalTotal()+gasto_final.getMGasto());
			Gasto gastoReturn = gastoService.create(gasto_final);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(gasto_final.getCartera());
		System.out.println(gasto_final.getCGasto());
		System.out.println(gasto_final.getMGasto());
		System.out.println(gasto_final.getTipoGasto().getNTipoGasto());
		
		return "redirect:/crearcartera/datosCartera/" + gasto_final.getCartera().getUsuario().getId() + "/" + gasto_final.getCartera().getCCartera();
	}
	
}