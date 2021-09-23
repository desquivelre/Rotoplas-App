package pe.edu.upc.rotoplas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@Column(name="Numcapacidadlitros",nullable = false)
	private Integer numcapacidadlitros;
	

}
