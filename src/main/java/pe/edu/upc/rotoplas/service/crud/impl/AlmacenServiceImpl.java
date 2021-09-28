package pe.edu.upc.rotoplas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.rotoplas.entities.Almacen;
import pe.edu.upc.rotoplas.repository.AlmacenRepository;
import pe.edu.upc.rotoplas.service.crud.AlmacenService;

public class AlmacenServiceImpl implements AlmacenService {

	@Autowired
	private AlmacenRepository almacenRepository;
	
	@Override
	public JpaRepository<Almacen, Integer> getRepository() {
		return almacenRepository;
	}

}
