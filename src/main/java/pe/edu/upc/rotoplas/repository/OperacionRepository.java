package pe.edu.upc.rotoplas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.rotoplas.entities.Operacion;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Integer> {

	@Query("SELECT c FROM Operacion c WHERE c.Cartera.CCartera = :id")
	List<Operacion> filterOperacionesByIdCartera(
			@Param("id") Integer id);
	
	
}
