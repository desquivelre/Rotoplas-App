package pe.edu.upc.rotoplas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.rotoplas.entities.Producto;
import pe.edu.upc.rotoplas.repository.ProductoRepository;
import pe.edu.upc.rotoplas.service.crud.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public JpaRepository<Producto, Integer> getRepository() {
		return productoRepository;
	}

}
