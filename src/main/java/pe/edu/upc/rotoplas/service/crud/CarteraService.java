package pe.edu.upc.rotoplas.service.crud;

import java.util.List;

import pe.edu.upc.rotoplas.entities.Cartera;

public interface CarteraService extends CrudService<Cartera, Integer>{
	List<Cartera> filterCarterasByIdUsuario(Integer id) throws Exception;
	

}
