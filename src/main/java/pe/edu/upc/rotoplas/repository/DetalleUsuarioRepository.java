package pe.edu.upc.rotoplas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.rotoplas.entities.DetalleUsuario;
import pe.edu.upc.rotoplas.entities.DetalleUsuarioID;

public interface DetalleUsuarioRepository extends JpaRepository<DetalleUsuario, DetalleUsuarioID>{

}
