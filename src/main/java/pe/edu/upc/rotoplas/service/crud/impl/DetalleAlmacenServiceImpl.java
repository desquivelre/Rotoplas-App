package pe.edu.upc.rotoplas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacenID;
import pe.edu.upc.rotoplas.entities.DetalleUsuario;
import pe.edu.upc.rotoplas.entities.DetalleUsuarioID;
import pe.edu.upc.rotoplas.repository.DetalleAlmacenRepository;
import pe.edu.upc.rotoplas.service.crud.DetalleAlmacenService;
import pe.edu.upc.rotoplas.service.crud.DetalleUsuarioService;

public class DetalleAlmacenServiceImpl implements DetalleAlmacenService{

	@Autowired
	private DetalleAlmacenRepository detalleAlmacenRepository;
	
	@Override
	public JpaRepository<DetalleAlmacen, DetalleAlmacenID> getRepository() {
		return detalleAlmacenRepository;
	}

	

}
