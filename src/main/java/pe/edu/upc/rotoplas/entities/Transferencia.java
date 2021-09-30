package pe.edu.upc.rotoplas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Transferencia")
@SequenceGenerator(name = "getTransferencia", initialValue = 1, allocationSize = 1)
public class Transferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getTransferencia")
    @Column(name="CTransferencia",columnDefinition = "NUMERIC(2)",nullable = false)
    private Integer CTransferencia;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cproducto", nullable = false)
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAlmacen_Local", nullable = false)
    private Almacen almacen_local;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAlmacen_Destino", nullable = false)
    private Almacen almacen_destino;

	public Transferencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transferencia(Integer cTransferencia, Integer cantidad, Producto producto, Almacen almacen_local,
			Almacen almacen_destino) {
		super();
		CTransferencia = cTransferencia;
		this.cantidad = cantidad;
		this.producto = producto;
		this.almacen_local = almacen_local;
		this.almacen_destino = almacen_destino;
	}

	public Integer getCTransferencia() {
		return CTransferencia;
	}

	public void setCTransferencia(Integer cTransferencia) {
		CTransferencia = cTransferencia;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Almacen getAlmacen_local() {
		return almacen_local;
	}

	public void setAlmacen_local(Almacen almacen_local) {
		this.almacen_local = almacen_local;
	}

	public Almacen getAlmacen_destino() {
		return almacen_destino;
	}

	public void setAlmacen_destino(Almacen almacen_destino) {
		this.almacen_destino = almacen_destino;
	}
	
	
	
	
}
