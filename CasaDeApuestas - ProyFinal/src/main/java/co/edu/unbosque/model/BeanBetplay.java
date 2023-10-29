package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import co.edu.unbosque.model.Beanapuestas;
@Entity
@Table(name="apuestas-betplay")
@ManagedBean
public class BeanBetplay {
	@Column(name="Resultado")
	private int resultado;
	@Column(name="Equipos")
	private String equipos;
	
	public BeanBetplay(int resultado, String equipos) {
		super();
		this.resultado = resultado;
		this.equipos = equipos;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public String getEquipos() {
		return equipos;
	}
	public void setEquipos(String equipos) {
		this.equipos = equipos;
	}
	
}
