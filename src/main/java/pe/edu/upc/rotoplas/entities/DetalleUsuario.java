package pe.edu.upc.rotoplas.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DetalleUsuario")
@Data
@NoArgsConstructor
@IdClass(DetalleUsuarioID.class)
public class DetalleUsuario  {
	
	@Id
	
	private DetalleUsuarioID usuario;
	
	@Id
	private DetalleAlmacenID almacen;

	public DetalleUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleUsuario(DetalleUsuarioID usuario, DetalleAlmacenID almacen) {
		super();
		this.usuario = usuario;
		this.almacen = almacen;
	}

	public DetalleUsuarioID getUsuario() {
		return usuario;
	}

	public void setUsuario(DetalleUsuarioID usuario) {
		this.usuario = usuario;
	}

	public DetalleAlmacenID getAlmacen() {
		return almacen;
	}

	public void setAlmacen(DetalleAlmacenID almacen) {
		this.almacen = almacen;
	}
	
	
}
