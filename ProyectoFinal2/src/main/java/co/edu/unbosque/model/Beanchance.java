package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import co.edu.unbosque.model.Beanapuestas;
@Entity
@Table(name="apuestas-chance")
@ManagedBean
public class Beanchance {
	@Column(name="Codigo")
	private int codigo;
	@Column(name="Numeros")
	private String numeros;
	
	public Beanchance(int codigo, String numeros) {
		super();
		this.codigo = codigo;
		this.numeros = numeros;
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
	

}
