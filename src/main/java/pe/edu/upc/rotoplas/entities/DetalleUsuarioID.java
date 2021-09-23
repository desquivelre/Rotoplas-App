package pe.edu.upc.rotoplas.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class DetalleUsuarioID implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer usuario;
	private Integer almacen;
	
	@Override
	public int hashCode() {
		return Objects.hash(usuario, almacen);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
	
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		DetalleUsuarioID detalleUsuarioID= (DetalleUsuarioID) obj;

		if (this.usuario!= detalleUsuarioID.usuario)
			return false;
		if (this.almacen!= detalleUsuarioID.almacen)
			return false;
		return true;
	}

	public DetalleUsuarioID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleUsuarioID(Integer usuario, Integer almacen) {
		super();
		this.usuario = usuario;
		this.almacen = almacen;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
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
