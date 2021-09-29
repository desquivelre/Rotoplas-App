package pe.edu.upc.rotoplas.service.crud.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.Color;
import pe.edu.upc.rotoplas.repository.ColorRepository;
import pe.edu.upc.rotoplas.service.crud.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorRepository colorRepository;
	
	@Override
	public JpaRepository<Color, Integer> getRepository() {
		return colorRepository;
	}


	
}
