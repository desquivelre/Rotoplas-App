package pe.edu.upc.rotoplas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Categoria")
public class Categoria {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Ccategoria", nullable = false)
	private Integer ccategoria;

	@Column(name = "Ncategoria", length = 30)
	private String ncategoria;
	
	
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Categoria> categoria;

}
