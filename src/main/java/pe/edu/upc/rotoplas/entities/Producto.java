package pe.edu.upc.rotoplas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Producto")
public class Producto {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CProducto", nullable = false)
	private Integer cproducto;
	
	@ManyToOne
	@JoinColumn(name = "CCategoria", nullable = false)
	private Categoria categoria; 
	
	@ManyToOne
	@JoinColumn(name = "CColor", nullable = false)
	private Color color; 
	
	@Column(name="Nproducto",length = 30,nullable=false)
	private String nproducto;
	
	@NotNull
	@Min(1)
	@Column(name="Numcapacidadlitros",nullable = false)
	private Integer numcapacidadlitros;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCproducto() {
		return cproducto;
	}

	public void setCproducto(Integer cproducto) {
		this.cproducto = cproducto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getNproducto() {
		return nproducto;
	}

	public void setNproducto(String nproducto) {
		this.nproducto = nproducto;
	}

	public Integer getNumcapacidadlitros() {
		return numcapacidadlitros;
	}

	public void setNumcapacidadlitros(Integer numcapacidadlitros) {
		this.numcapacidadlitros = numcapacidadlitros;
	}

	public Producto(Integer cproducto, Categoria categoria, Color color, String nproducto,
			@NotNull @Min(1) Integer numcapacidadlitros) {
		super();
		this.cproducto = cproducto;
		this.categoria = categoria;
		this.color = color;
		this.nproducto = nproducto;
		this.numcapacidadlitros = numcapacidadlitros;
	}


	
	
	

}
