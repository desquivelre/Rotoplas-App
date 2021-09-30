package pe.edu.upc.rotoplas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="DetalleAlmacen")
@Data
@NoArgsConstructor
@IdClass(DetalleAlmacenID.class)
public class DetalleAlmacen {
	@Id
	@ManyToOne()
	@JoinColumn(name = "CProducto", nullable = false)
	private Producto producto;
	
	@Id
	@ManyToOne()
	@JoinColumn(name = "CAlmacen", nullable = false)
	private Almacen almacen;
	
	@NotNull
	@Min(1)
	@Column(name = "StockProducto", columnDefinition = "NUMERIC(10)")
    private Integer StockProducto;

	public DetalleAlmacen() {
		super();
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

	public DetalleAlmacen(Producto producto, Almacen almacen, @NotNull @Min(1) Integer stockProducto) {
		super();
		this.producto = producto;
		this.almacen = almacen;
		StockProducto = stockProducto;
	}


}
