package pe.edu.upc.rotoplas.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.repository.RegisterRepository;
import pe.edu.upc.rotoplas.repository.UsuarioRepository;
import pe.edu.upc.rotoplas.service.crud.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepository registerRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public JpaRepository<Usuario, Integer> getRepository() {
		return registerRepository;
	}

	@Override
	public Usuario findByNUsuario(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
    public boolean checkDniAvaiable(Usuario usuario) throws Exception{
		
		Optional<Usuario> dniFound= usuarioRepository.findByDNI(usuario.getDNI());
		if(dniFound.isPresent()) {
			throw new Exception("Dni no disponible");
		}
		return true;
	}
    
public boolean checkUsernameAvaiable(Usuario usuario) throws Exception{
		
		Optional<Usuario> nusuarioFound= usuarioRepository.findByNUsuario(usuario.getNUsuario());
		if(nusuarioFound.isPresent()) {
			throw new Exception("Usuario no disponible");
		}
		return true;
	}
    
	@Override 
	public Usuario registrar(Usuario u) throws Exception{
		if(checkDniAvaiable(u) && checkUsernameAvaiable(u)) {
			u.setContrasena(passwordEncoder.encode(u.getContrasena()));
			return registerRepository.save(u);		
			
		}
	return u;
	}
     
	
}