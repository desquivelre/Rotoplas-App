package pe.edu.upc.rotoplas.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacenID;
import pe.edu.upc.rotoplas.entities.DetalleUsuario;
import pe.edu.upc.rotoplas.entities.DetalleUsuarioID;
import pe.edu.upc.rotoplas.repository.DetalleAlmacenRepository;
import pe.edu.upc.rotoplas.service.crud.DetalleAlmacenService;
import pe.edu.upc.rotoplas.service.crud.DetalleUsuarioService;

@Service
public class DetalleAlmacenServiceImpl implements DetalleAlmacenService{

	@Autowired
	private DetalleAlmacenRepository detalleAlmacenRepository;
	
	@Override
	public JpaRepository<DetalleAlmacen, DetalleAlmacenID> getRepository() {
		return detalleAlmacenRepository;
	}

	@Override
	public List<DetalleAlmacen> filterByAlmacen(Integer idAlmacen) throws Exception {
		// TODO Auto-generated method stub
		return detalleAlmacenRepository.filterByAlmacen(idAlmacen);
	}

	@Override
	public DetalleAlmacen registrar(DetalleAlmacen a) {
		// TODO Auto-generated method stub
		return detalleAlmacenRepository.save(a);
		
	}

	

}
