package pe.edu.upc.rotoplas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pe.edu.upc.rotoplas.entities.DetalleAlmacen;
import pe.edu.upc.rotoplas.entities.DetalleAlmacenID;

public interface DetalleAlmacenRepository extends JpaRepository<DetalleAlmacen, DetalleAlmacenID> {
	@Query("SELECT c FROM DetalleAlmacen c WHERE c.almacen.CAlmacen = :idalmacen")
	List<DetalleAlmacen>filterByAlmacen(@Param("idalmacen")Integer idalmacen);
	
	@Query("SELECT c FROM DetalleAlmacen c WHERE c.almacen.CAlmacen = :idalmacen AND c.producto.cproducto = :idproducto")
	List<DetalleAlmacen>filterByAlmacenProducto(@Param("idalmacen")Integer idalmacen, @Param("idproducto")Integer idproducto);

}
