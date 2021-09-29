package pe.edu.upc.rotoplas.service.crud;

import java.util.List;

import org.springframework.stereotype.Service;


import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacenID;

@Service
public interface DetalleAlmacenService extends CrudService<DetalleAlmacen, DetalleAlmacenID> {

	List<DetalleAlmacen>filterByAlmacen(Integer idAlmacen) throws Exception;
}
