package pe.edu.upc.rotoplas.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.TipoMoneda;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.repository.TipoMonedaRepository;
import pe.edu.upc.rotoplas.service.crud.TipoMonedaService;

@Service
public class TipoMonedaServiceImpl implements TipoMonedaService {

	@Autowired
	private TipoMonedaRepository tipomonedaRepository;
	@Override
	public JpaRepository<TipoMoneda, Integer> getRepository() {
		// TODO Auto-generated method stub
		return tipomonedaRepository;
	}


}
