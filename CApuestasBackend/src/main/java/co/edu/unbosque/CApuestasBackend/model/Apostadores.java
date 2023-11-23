package co.edu.unbosque.CApuestasBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Apostadores {
	@Id
	private int cedula;
	private String nombre;
	private String sede;
	private String direccion;
	private int celular;
	
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombreC(String nombre) {
		this.nombre = nombre;
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
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	
	
}
