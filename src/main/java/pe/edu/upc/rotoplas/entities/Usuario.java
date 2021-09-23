package pe.edu.upc.rotoplas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Users")
public class Usuario {
    @Id 
    @NotNull
    @Range(min=10000000,max=99999999)
    @Column(name = "DNI", length = 8, nullable = false)
    private Integer DNI;

    @NotEmpty
    @Column(name = "NUsuario", length = 30, nullable = false)
    private String NUsuario;

    @NotEmpty
    @Column(name = "Contrasena", length = 300, nullable = false)
    private String Contrasena;
    
    @NotEmpty
    @Column(name = "TDireccionUsario", length = 50, nullable = false)
    private String TDireccionUsario;
    
    @NotEmpty
    @Column(name = "NumCelular", length = 9, nullable = false)
    private String NumCelular;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<DetalleUsuario> DetallesUsuario;
    
    
    


    @OneToMany(mappedBy = "usuario",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private List<Authority>authorities;

    private boolean enable;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
		this.enable=true;
        this.authorities= new ArrayList<>();
	}

	public Usuario(@NotNull @Range(min = 10000000, max = 99999999) Integer dNI, @NotEmpty String nUsuario,
			@NotEmpty String contrasena, @NotEmpty String tDIreccionUsuario, @NotEmpty String numCelular,
			List<DetalleUsuario> detallesUsuario,List<Authority> authorities, boolean enable) {
		super();
		DNI = dNI;
		NUsuario = nUsuario;
		Contrasena = contrasena;
		TDireccionUsario = tDIreccionUsuario;
		NumCelular = numCelular;
		DetallesUsuario = detallesUsuario;
	
		this.authorities = authorities;
		this.enable = enable;
	}






	public Integer getDNI() {
		return DNI;
	}

	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	public String getNUsuario() {
		return NUsuario;
	}

	public void setNUsuario(String nUsuario) {
		NUsuario = nUsuario;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}



	public String getTDireccionUsario() {
		return TDireccionUsario;
	}

	public void setTDireccionUsario(String tDireccionUsario) {
		TDireccionUsario = tDireccionUsario;
	}

	public String getNumCelular() {
		return NumCelular;
	}

	public void setNumCelular(String numCelular) {
		NumCelular = numCelular;
	}

	public List<DetalleUsuario> getDetallesUsuario() {
		return DetallesUsuario;
	}

	public void setDetallesUsuario(List<DetalleUsuario> detallesUsuario) {
		DetallesUsuario = detallesUsuario;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

   


}