package pe.edu.upc.rotoplas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "getDistrito", initialValue = 1, allocationSize = 1)
@Table(name="Distrito")
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getDistrito")
    @Column(name="CDistrito",columnDefinition = "NUMERIC(2)",nullable = false)
    private Integer CDistrito;

    @Column(name="NDistrito",length=30)
    private String NDistrito;

    @OneToMany(mappedBy = "distrito", fetch = FetchType.LAZY)
    private List<Almacen> Almacenes;

	public Distrito(Integer cDistrito, String nDistrito, List<Almacen> almacenes) {
		super();
		CDistrito = cDistrito;
		NDistrito = nDistrito;
		Almacenes = almacenes;
	}

	public Distrito() {
		super();
	}

	public Integer getCDistrito() {
		return CDistrito;
	}

	public void setCDistrito(Integer cDistrito) {
		CDistrito = cDistrito;
	}

	public String getNDistrito() {
		return NDistrito;
	}

	public void setNDistrito(String nDistrito) {
		NDistrito = nDistrito;
	}

	public List<Almacen> getAlmacenes() {
		return Almacenes;
	}

	public void setAlmacenes(List<Almacen> almacenes) {
		Almacenes = almacenes;
	}
    
}