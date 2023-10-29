package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="configuracion")
@ManagedBean
public class BeansParametrizacion {
	@Column(name="NombreCasa")
	private String Nombrecasa;
	@Column(name="NumeroSedes")
	private int numerosedes;
	@Column(name="Presupuesto")
	private String presupuesto;
	
	public BeansParametrizacion(String nombrecasa, int numerosedes, String presupuesto) {
		super();
		Nombrecasa = nombrecasa;
		this.numerosedes = numerosedes;
		this.presupuesto = presupuesto;
	}
	public String getNombrecasa() {
		return Nombrecasa;
	}
	public void setNombrecasa(String nombrecasa) {
		Nombrecasa = nombrecasa;
	}
	public int getNumerosedes() {
		return numerosedes;
	}
	public void setNumerosedes(int numerosedes) {
		this.numerosedes = numerosedes;
	}
	public String getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}

}
