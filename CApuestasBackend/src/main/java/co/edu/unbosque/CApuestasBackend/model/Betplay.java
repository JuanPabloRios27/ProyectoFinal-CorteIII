package co.edu.unbosque.CApuestasBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Betplay {
	@Id
	private int codigo;
	private String partido;
	private int resultado;
	private String dApuesta;
	private int apuesta;
	
	public int getApuesta() {
		return apuesta;
	}
	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public String getdApuesta() {
		return dApuesta;
	}
	public void setdApuesta(String dApuesta) {
		this.dApuesta = dApuesta;
	}
	
}
