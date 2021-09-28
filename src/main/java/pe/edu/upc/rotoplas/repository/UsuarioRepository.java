package pe.edu.upc.rotoplas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.rotoplas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
