package pe.edu.upc.rotoplas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TipoGasto")
public class TipoGasto {
	@Id 
	@Column(name = "CTipoGasto", length = 4, nullable = false)
	private Integer CTipoGasto;
	
	@Column(name = "NTipoGasto", length = 20)
	private String NTipoGasto;
	
	@OneToMany(mappedBy = "TipoGasto", fetch = FetchType.LAZY)
	private List<Gasto> gastos;

	public TipoGasto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoGasto(Integer cTipoGasto, String nTipoGasto, List<Gasto> gastos) {
		super();
		CTipoGasto = cTipoGasto;
		NTipoGasto = nTipoGasto;
		this.gastos = gastos;
	}

	public Integer getCTipoGasto() {
		return CTipoGasto;
	}

	public void setCTipoGasto(Integer cTipoGasto) {
		CTipoGasto = cTipoGasto;
	}

	public String getNTipoGasto() {
		return NTipoGasto;
	}

	public void setNTipoGasto(String nTipoGasto) {
		NTipoGasto = nTipoGasto;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
	
	
	
}
