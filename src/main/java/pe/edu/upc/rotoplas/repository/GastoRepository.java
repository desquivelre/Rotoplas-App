package pe.edu.upc.rotoplas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.rotoplas.entities.Gasto;

@Repository
public interface GastoRepository extends JpaRepository<Gasto,Integer>{

}
