package pe.edu.upc.rotoplas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Almacen")
@SequenceGenerator(name = "getAlmacen", initialValue = 1, allocationSize = 1)
public class Almacen {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getAlmacen")
    @Column(name="CAlmacen",columnDefinition = "NUMERIC(2)",nullable = false)
    private Integer CAlmacen;

    @Column(name="TDireccionAlmacen",length=50)
    private String TDireccionAlmacen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CDistrito", nullable = false)
    private Distrito distrito;

    @OneToMany(mappedBy = "almacen_local", fetch = FetchType.LAZY)
    private List<Transferencia> Transferencia_local;
    
    @OneToMany(mappedBy = "almacen_destino", fetch = FetchType.LAZY)
    private List<Transferencia> Transferencia_destino;

	public Almacen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Almacen(Integer cAlmacen, String tDireccionAlmacen, Distrito distrito,
			List<Transferencia> transferencia_local, List<Transferencia> transferencia_destino) {
		super();
		CAlmacen = cAlmacen;
		TDireccionAlmacen = tDireccionAlmacen;
		this.distrito = distrito;
		Transferencia_local = transferencia_local;
		Transferencia_destino = transferencia_destino;
	}

	public Integer getCAlmacen() {
		return CAlmacen;
	}

	public void setCAlmacen(Integer cAlmacen) {
		CAlmacen = cAlmacen;
	}

	public String getTDireccionAlmacen() {
		return TDireccionAlmacen;
	}

	public void setTDireccionAlmacen(String tDireccionAlmacen) {
		TDireccionAlmacen = tDireccionAlmacen;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Transferencia> getTransferencia_local() {
		return Transferencia_local;
	}

	public void setTransferencia_local(List<Transferencia> transferencia_local) {
		Transferencia_local = transferencia_local;
	}

	public List<Transferencia> getTransferencia_destino() {
		return Transferencia_destino;
	}

	public void setTransferencia_destino(List<Transferencia> transferencia_destino) {
		Transferencia_destino = transferencia_destino;
	}
    
    
	
	
}
