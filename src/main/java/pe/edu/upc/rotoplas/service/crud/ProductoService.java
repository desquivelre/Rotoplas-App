package pe.edu.upc.rotoplas.service.crud;

import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.Producto;
import pe.edu.upc.rotoplas.entities.Usuario;

@Service
public interface ProductoService extends CrudService<Producto, Integer> {
	public Producto registrar(Producto p);
}
