package pe.edu.upc.rotoplas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.rotoplas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
   public Optional<Usuario> findByDNI(Integer DNI);
   public Optional<Usuario> findByNUsuario(String nUsuario);
}
