package pe.edu.upc.rotoplas.service.crud.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;



import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.repository.UsuarioRepository;
import pe.edu.upc.rotoplas.service.crud.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public JpaRepository<Usuario, Integer> getRepository() {
		return usuarioRepository;
	}
	
	
	

}
