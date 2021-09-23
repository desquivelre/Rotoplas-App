package pe.edu.upc.rotoplas.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.Cartera;
import pe.edu.upc.rotoplas.entities.Usuario;
import pe.edu.upc.rotoplas.repository.CarteraRepository;
import pe.edu.upc.rotoplas.service.crud.CarteraService;

@Service
public class CarteraServiceImpl implements CarteraService {

	@Autowired
	private CarteraRepository carteraRepository;
	
	@Override
	public JpaRepository<Cartera, Integer> getRepository() {
		// TODO Auto-generated method stub
		return carteraRepository;
	}

	@Override
	public List<Cartera> filterCarterasByIdUsuario(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return carteraRepository.filterCarterasByIdUsuario(id);
	}


}
