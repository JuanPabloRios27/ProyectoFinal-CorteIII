package co.edu.unbosque.CApuestasBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Config {
	@Id
	private String nombre;
	private int sedes;
	private int presupuesto;

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSedes() {
		return sedes;
	}
	public void setSedes(int sedes) {
		this.sedes = sedes;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
}
