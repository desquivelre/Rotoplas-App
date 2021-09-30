package pe.edu.upc.rotoplas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.rotoplas.entities.Transferencia;
import pe.edu.upc.rotoplas.repository.TransferenciaRepository;
import pe.edu.upc.rotoplas.service.crud.TransferenciaService;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Override
	public JpaRepository<Transferencia, Integer> getRepository() {
		return transferenciaRepository;
	}

}
