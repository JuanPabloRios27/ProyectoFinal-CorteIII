package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="apostadores")
@ManagedBean
public class Beanapostadores {
	//
	@Column(name="Cedula")
	private String Cedula;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Sede")
	private String sede;
	@Column(name="Dirreccion")
	private String dirreccion;
	@Column(name="Celular")
	private String Celular;
	
	public Beanapostadores(String cedula, String nombre, String sede, String dirreccion, String celular) {
		super();
		Cedula = cedula;
		this.nombre = nombre;
		this.sede = sede;
		this.dirreccion = dirreccion;
		Celular = celular;
	}
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getDirreccion() {
		return dirreccion;
	}
	public void setDirreccion(String dirreccion) {
		this.dirreccion = dirreccion;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		Celular = celular;
	}
	

}