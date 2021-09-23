package pe.edu.upc.rotoplas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.rotoplas.entities.Tasa;

@Repository
public interface TasaRepository extends JpaRepository<Tasa, Integer>{

}
