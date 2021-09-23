package pe.edu.upc.rotoplas.service.crud;

import java.util.Date;
import java.util.List;

import pe.edu.upc.rotoplas.entities.Operacion;

public interface OperacionService extends CrudService<Operacion, Integer>{
	
	List<Operacion> filterOperacionesByIdCartera(Integer id) throws Exception;

}
