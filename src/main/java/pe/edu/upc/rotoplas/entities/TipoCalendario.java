package pe.edu.upc.rotoplas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TipoCalendario")
public class TipoCalendario {
	@Id 
	@Column(name = "CTipoCalendario", length = 4, nullable = false)
	private Integer CTipoCalendario;
	
	@Column(name = "NTipoCalendario", length = 20)
	private String TipoCalendario;
	
	@OneToMany(mappedBy = "TipoCalendario", fetch = FetchType.LAZY)
	private List<Cartera> carteras;

	public TipoCalendario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoCalendario(Integer cTipoCalendario, String tipoCalendario, List<Cartera> carteras) {
		super();
		CTipoCalendario = cTipoCalendario;
		TipoCalendario = tipoCalendario;
		this.carteras = carteras;
	}

	public Integer getCTipoCalendario() {
		return CTipoCalendario;
	}

	public void setCTipoCalendario(Integer cTipoCalendario) {
		CTipoCalendario = cTipoCalendario;
	}

	public String getTipoCalendario() {
		return TipoCalendario;
	}

	public void setTipoCalendario(String tipoCalendario) {
		TipoCalendario = tipoCalendario;
	}

	public List<Cartera> getCarteras() {
		return carteras;
	}

	public void setCarteras(List<Cartera> carteras) {
		this.carteras = carteras;
	}
	
	
}
