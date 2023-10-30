package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="juegos")
@ManagedBean
public class Beanjuego {
	//
	@Column(name="Codigo")
	private int codigo;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Tipo")
	private String tipo;
	@Column(name="Presupuesto")
	private String presupuesto;
	
	public Beanjuego(int codigo, String nombre, String tipo, String presupuesto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.presupuesto = presupuesto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}
	
}
