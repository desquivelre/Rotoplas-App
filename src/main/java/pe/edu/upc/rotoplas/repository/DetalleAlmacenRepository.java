package pe.edu.upc.rotoplas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacenID;

public interface DetalleAlmacenRepository extends JpaRepository<DetalleAlmacen, DetalleAlmacenID> {

}
