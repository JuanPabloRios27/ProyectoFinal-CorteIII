package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@ManagedBean
public class Beanapuestas {
	@Column(name="Codigo")
	private String codigo;
	@Column(name="ValorApuesta")
	private String valorapuesta;
	public Beanapuestas(String codigo, String valorapuesta) {
		super();
		this.codigo = codigo;
		this.valorapuesta = valorapuesta;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValorapuesta() {
		return valorapuesta;
	}
	public void setValorapuesta(String valorapuesta) {
		this.valorapuesta = valorapuesta;
	}
	

}
