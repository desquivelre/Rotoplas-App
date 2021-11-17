package pe.edu.upc.rotoplas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.rotoplas.entities.Usuario;
@Repository
public interface RegisterRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByNUsuario(String nusuario);

	


}
