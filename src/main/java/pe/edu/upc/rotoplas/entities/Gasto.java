package pe.edu.upc.rotoplas.entities;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Gasto")
public class Gasto {
	@Id 
	@Column(name = "CGasto", length = 4, nullable = false)
	private Integer CGasto;
	
	@Column(name = "MGasto", length = 20)
	private Float MGasto;
	
	@ManyToOne
	@JoinColumn(name = "CCartera", nullable = false)
	private Cartera Cartera; 
	
	@ManyToOne
	@JoinColumn(name = "CTipoGasto", nullable = false)
	private TipoGasto TipoGasto;

	public Gasto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gasto(Integer cGasto, Float mGasto, pe.edu.upc.rotoplas.entities.Cartera cartera,
			pe.edu.upc.rotoplas.entities.TipoGasto tipoGasto) {
		super();
		CGasto = cGasto;
		MGasto = mGasto;
		Cartera = cartera;
		TipoGasto = tipoGasto;
	}

	public Integer getCGasto() {
		return CGasto;
	}

	public void setCGasto(Integer cGasto) {
		CGasto = cGasto;
	}

	public Float getMGasto() {
		return MGasto;
	}

	public void setMGasto(Float mGasto) {
		MGasto = mGasto;
	}

	public Cartera getCartera() {
		return Cartera;
	}

	public void setCartera(Cartera cartera) {
		Cartera = cartera;
	}

	public TipoGasto getTipoGasto() {
		return TipoGasto;
	}

	public void setTipoGasto(TipoGasto tipoGasto) {
		TipoGasto = tipoGasto;
	} 
	
}
