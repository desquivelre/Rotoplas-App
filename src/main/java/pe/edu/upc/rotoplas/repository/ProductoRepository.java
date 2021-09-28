package pe.edu.upc.rotoplas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.rotoplas.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
