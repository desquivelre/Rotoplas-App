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


	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Categoria(Integer ccategoria, String ncategoria, List<Categoria> categoria) {
		super();
		this.ccategoria = ccategoria;
		this.ncategoria = ncategoria;
		this.categoria = categoria;
	}


	public Integer getCcategoria() {
		return ccategoria;
	}


	public void setCcategoria(Integer ccategoria) {
		this.ccategoria = ccategoria;
	}


	public String getNcategoria() {
		return ncategoria;
	}


	public void setNcategoria(String ncategoria) {
		this.ncategoria = ncategoria;
	}


	public List<Categoria> getCategoria() {
		return categoria;
	}


	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	

}
