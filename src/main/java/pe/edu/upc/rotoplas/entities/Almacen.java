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
    
 
    
    @OneToMany(mappedBy = "almacen", fetch = FetchType.LAZY)
    private List<DetalleUsuario> DetallesUsuario;

	public Almacen() {
		super();
	}

	public Almacen(Integer cAlmacen, String tDireccionAlmacen, Distrito distrito, 
			List<DetalleUsuario> detallesUsuario) {
		super();
		CAlmacen = cAlmacen;
		TDireccionAlmacen = tDireccionAlmacen;
		this.distrito = distrito;
		
		DetallesUsuario = detallesUsuario;
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



	public List<DetalleUsuario> getDetallesUsuario() {
		return DetallesUsuario;
	}

	public void setDetallesUsuario(List<DetalleUsuario> detallesUsuario) {
		DetallesUsuario = detallesUsuario;
	}
	
}
