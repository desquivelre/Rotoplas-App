package pe.edu.upc.rotoplas.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_usuario")
public class DetalleUsuario {
	
	@Id
	@ManyToOne()
	@JoinColumn(name = "DNI", nullable = false)
	private Usuario usuario;
	
	@Id
	@ManyToOne()
	@JoinColumn(name = "CAlmacen", nullable = false)
	private Almacen almacen;

	public DetalleUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleUsuario(Usuario usuario, Almacen almacen) {
		super();
		this.usuario = usuario;
		this.almacen = almacen;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
	
	
}
