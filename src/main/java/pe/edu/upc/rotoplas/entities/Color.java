package pe.edu.upc.rotoplas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="color")
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Ccolor", nullable = false)
	private Integer ccolor;

	@Column(name = "Ncolor", length = 30)
	private String ncolores;
	
	@OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
	private List<Color> color;

	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Color(Integer ccolor, String ncolores, List<Color> color) {
		super();
		this.ccolor = ccolor;
		this.ncolores = ncolores;
		this.color = color;
	}

	public Integer getCcolor() {
		return ccolor;
	}

	public void setCcolor(Integer ccolor) {
		this.ccolor = ccolor;
	}

	public String getNcolores() {
		return ncolores;
	}

	public void setNcolores(String ncolores) {
		this.ncolores = ncolores;
	}

	public List<Color> getColor() {
		return color;
	}

	public void setColor(List<Color> color) {
		this.color = color;
	}
	
	

	
	
}
