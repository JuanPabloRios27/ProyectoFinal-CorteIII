package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import co.edu.unbosque.model.Beanapuestas;
@Entity
@Table(name="apuetas-loteria")
@ManagedBean
public class Beanloteria {
	@Column(name="Codigo")
	private int codigo;
	@Column(name="Numeros")
	private String numeros;
	@Column(name="Serie")
	private String serie;
	
	public Beanloteria(int codigo, String numeros, String serie) {
		super();
		this.codigo = codigo;
		this.numeros = numeros;
		this.serie = serie;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumeros() {
		return numeros;
	}
	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}

}
