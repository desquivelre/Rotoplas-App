package pe.edu.upc.rotoplas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.rotoplas.entities.TipoGasto;

@Repository
public interface TipoGastoRepository extends JpaRepository<TipoGasto, Integer>{

}
