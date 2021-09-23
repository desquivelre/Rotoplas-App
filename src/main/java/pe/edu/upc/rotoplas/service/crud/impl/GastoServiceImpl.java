package pe.edu.upc.rotoplas.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.Gasto;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.repository.GastoRepository;
import pe.edu.upc.rotoplas.service.crud.GastoService;

@Service
public class GastoServiceImpl implements GastoService{

	@Autowired
	private GastoRepository gastoRepository;
	@Override
	public JpaRepository<Gasto, Integer> getRepository() {
		// TODO Auto-generated method stub
		return gastoRepository;
	}


}
