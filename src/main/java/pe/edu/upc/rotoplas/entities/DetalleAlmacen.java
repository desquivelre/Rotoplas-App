package pe.edu.upc.rotoplas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetalleAlmacen")
public class DetalleAlmacen {
	@Id
	@ManyToOne()
	@JoinColumn(name = "CProducto", nullable = false)
	private Producto producto;
	
	@Id
	@ManyToOne()
	@JoinColumn(name = "CAlmacen", nullable = false)
	private Almacen almacen;
	
	@Column(name = "StockProducto", columnDefinition = "NUMERIC(10)")
    private Integer StockProducto;

	public DetalleAlmacen() {
		super();
	}

	public DetalleAlmacen(Producto producto, Almacen almacen, Integer stockProducto) {
		super();
		this.producto = producto;
		this.almacen = almacen;
		StockProducto = stockProducto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Integer getStockProducto() {
		return StockProducto;
	}

	public void setStockProducto(Integer stockProducto) {
		StockProducto = stockProducto;
	}
	
	
}
