package pe.edu.upc.rotoplas.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.Tasa;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.repository.TasaRepository;
import pe.edu.upc.rotoplas.service.crud.TasaService;

@Service
public class TasaServiceImpl implements TasaService{

	@Autowired
	private TasaRepository tasaRepository;
	@Override
	public JpaRepository<Tasa, Integer> getRepository() {
		// TODO Auto-generated method stub
		return tasaRepository;
	}

}
