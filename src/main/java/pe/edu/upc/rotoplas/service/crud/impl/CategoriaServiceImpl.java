package pe.edu.upc.rotoplas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.Categoria;
import pe.edu.upc.rotoplas.repository.CategoriaRepository;
import pe.edu.upc.rotoplas.service.crud.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaReposiroty;
	
	@Override
	public JpaRepository<Categoria, Integer> getRepository() {
		return categoriaReposiroty;
	}

}
