package pe.edu.upc.rotoplas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Tasa")
public class Tasa {
	@Id 
	@Column(name = "CTasa", length = 4, nullable = false)
	private Integer CTasa;
	
	@Column(name = "NTasa", length = 20)
	private String NTasa;
	
	@OneToMany(mappedBy = "Tasa", fetch = FetchType.LAZY)
	private List<Cartera> carteras;

	public Tasa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tasa(Integer cTasa, String nTasa, List<Cartera> carteras) {
		super();
		CTasa = cTasa;
		NTasa = nTasa;
		this.carteras = carteras;
	}

	public Integer getCTasa() {
		return CTasa;
	}

	public void setCTasa(Integer cTasa) {
		CTasa = cTasa;
	}

	public String getNTasa() {
		return NTasa;
	}

	public void setNTasa(String nTasa) {
		NTasa = nTasa;
	}

	public List<Cartera> getCarteras() {
		return carteras;
	}

	public void setCarteras(List<Cartera> carteras) {
		this.carteras = carteras;
	}



	
	
	
}
