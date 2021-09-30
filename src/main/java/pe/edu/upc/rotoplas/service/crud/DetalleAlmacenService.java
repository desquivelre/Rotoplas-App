package pe.edu.upc.rotoplas.service.crud;

import java.util.List;

import org.springframework.stereotype.Service;


import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacenID;

@Service
public interface DetalleAlmacenService extends CrudService<DetalleAlmacen, DetalleAlmacenID> {

	List<DetalleAlmacen>filterByAlmacen(Integer idAlmacen) throws Exception;
	List<DetalleAlmacen>filterByAlmacenProducto(Integer idAlmacen, Integer idProducto) throws Exception;
	
	List<DetalleAlmacen>filterByAlmacenCategoria(Integer idAlmacen, Integer idCategoria) throws Exception;
	List<DetalleAlmacen>filterByAlmacenColor(Integer idAlmacen, Integer idColor) throws Exception;
}
