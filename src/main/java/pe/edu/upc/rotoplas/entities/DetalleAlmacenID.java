package pe.edu.upc.rotoplas.entities;

import java.io.Serializable;
import java.util.Objects;



import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DetalleAlmacenID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer producto;
	private Integer almacen;
	
	@Override
	public int hashCode() {
		return Objects.hash(producto, almacen);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
	
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		DetalleAlmacenID detalleAlmacenID= (DetalleAlmacenID) obj;

		if (this.producto!= detalleAlmacenID.producto)
			return false;
		if (this.almacen!= detalleAlmacenID.almacen)
			return false;
		return true;
	}

	public DetalleAlmacenID() {
		super();
	}

	public DetalleAlmacenID(Integer producto, Integer almacen) {
		super();
		this.producto = producto;
		this.almacen = almacen;
	}

	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	public Integer getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Integer almacen) {
		this.almacen = almacen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
