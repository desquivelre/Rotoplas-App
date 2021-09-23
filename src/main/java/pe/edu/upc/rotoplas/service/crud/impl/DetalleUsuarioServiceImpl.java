package pe.edu.upc.rotoplas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.rotoplas.entities.DetalleUsuario;
import pe.edu.upc.rotoplas.entities.DetalleUsuarioID;
import pe.edu.upc.rotoplas.repository.DetalleUsuarioRepository;
import pe.edu.upc.rotoplas.service.crud.DetalleUsuarioService;

public class DetalleUsuarioServiceImpl implements DetalleUsuarioService {

	@Autowired
	private DetalleUsuarioRepository detalleUsuarioRepository;
	
	@Override
	public JpaRepository<DetalleUsuario, DetalleUsuarioID> getRepository() {
		return detalleUsuarioRepository;
	}

}
