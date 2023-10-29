package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import co.edu.unbosque.model.Beanapuestas;
@Entity
@Table(name="apuestas-baloto")
@ManagedBean
public class Beanbaloto {
	/**
	 * Esta variable se denomina números, y permite tener los números dados en los datos. 
	 */
	@Column(name="Numeros")
	private String numeros;//1-45 no se deben repetir

	public String getNumeros() {
		return numeros;
	}

	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}
	
}
