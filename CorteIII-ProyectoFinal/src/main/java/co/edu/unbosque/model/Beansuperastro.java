package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import co.edu.unbosque.model.Beanapuestas;
@Entity
@Table(name="apuestas-superastro")
@ManagedBean
public class Beansuperastro {
	@Column(name="Numeros")
	private String numeros;
	@Column(name="Signo")
	private String zodiaco;
	
	public Beansuperastro(String numeros, String zodiaco) {
		super();
		this.numeros = numeros;
		this.zodiaco = zodiaco;
	}
	public String getNumeros() {
		return numeros;
	}
	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}
	public String getZodiaco() {
		return zodiaco;
	}
	public void setZodiaco(String zodiaco) {
		this.zodiaco = zodiaco;
	}
	

}
