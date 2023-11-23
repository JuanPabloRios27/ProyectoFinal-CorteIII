package co.edu.unbosque.CApuestasBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Sede {
	@Id
	private int codigo;
	private String nombre;
	private int nTrabajadores;
	private String afiliacion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getAfiliacion() {
		return afiliacion;
	}
	public void setAfiliacion(String afiliacion) {
		this.afiliacion = afiliacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getnTrabajadores() {
		return nTrabajadores;
	}
	public void setnTrabajadores(int nTrabajadores) {
		this.nTrabajadores = nTrabajadores;
	}
	
}
