package pe.edu.upc.rotoplas.service.crud;
import java.util.List;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.rotoplas.entities.Usuario;

public interface RegisterService  extends CrudService<Usuario, Integer> {

	
	public Usuario findByNUsuario(String nusuario);
	public Usuario registrar(Usuario u) throws Exception;

}
