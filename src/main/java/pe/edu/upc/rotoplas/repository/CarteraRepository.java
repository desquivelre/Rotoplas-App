package pe.edu.upc.rotoplas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.rotoplas.entities.Cartera;


@Repository
public interface CarteraRepository extends JpaRepository<Cartera, Integer>{

	@Query("SELECT c FROM Cartera c WHERE c.Usuario.id = :id")
	List<Cartera> filterCarterasByIdUsuario(
			@Param("id") Integer id);
	
}
