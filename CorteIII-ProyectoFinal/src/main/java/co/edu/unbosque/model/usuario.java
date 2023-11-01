package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class usuario {
	
	private long cedula;
	private String nombreC;
	private String sede;
	private String direccion;
	private long celular;
	private String password;
	
	
	public long getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombreC() {
		return nombreC;
	}
	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public long getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	
	public String  envia() {
		return "seleccion-apuesta.xhtml";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
