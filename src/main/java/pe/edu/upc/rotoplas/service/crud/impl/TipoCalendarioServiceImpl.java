package pe.edu.upc.rotoplas.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.TipoCalendario;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.repository.TipoCalendarioRepository;
import pe.edu.upc.rotoplas.service.crud.TipoCalendarioService;

@Service
public class TipoCalendarioServiceImpl implements TipoCalendarioService{

	@Autowired
	private TipoCalendarioRepository tipocalendarioRepository;
	@Override
	public JpaRepository<TipoCalendario, Integer> getRepository() {
		// TODO Auto-generated method stub
		return tipocalendarioRepository;
	}


}
