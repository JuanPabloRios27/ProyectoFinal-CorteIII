package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="sedes")
@ManagedBean
public class Gestionsedes {
	@Column(name="Codigo")
	private int codigo;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="NEmpleados")
	private int nempleados;
	
	public Gestionsedes(int codigo, String nombre, int nempleados) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nempleados = nempleados;
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
	public int getNempleados() {
		return nempleados;
	}
	public void setNempleados(int nempleados) {
		this.nempleados = nempleados;
	}

}
