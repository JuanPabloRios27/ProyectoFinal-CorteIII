package co.edu.unbosque.CApuestasBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Superastro {
	@Id
	private int codigo;
	private int numerou1;
	private int numerou2;
	private int numerou3;
	private int numerou4;
	private String signou;
	private int apuesta;
	private String dApuesta;
	
	
	public int getApuesta() {
		return apuesta;
	}
	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}
	public String getdApuesta() {
		return dApuesta;
	}
	public void setdApuesta(String dApuesta) {
		this.dApuesta = dApuesta;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumerou1() {
		return numerou1;
	}
	public void setNumerou1(int numerou1) {
		this.numerou1 = numerou1;
	}
	public int getNumerou2() {
		return numerou2;
	}
	public void setNumerou2(int numerou2) {
		this.numerou2 = numerou2;
	}
	public int getNumerou3() {
		return numerou3;
	}
	public void setNumerou3(int numerou3) {
		this.numerou3 = numerou3;
	}
	public int getNumerou4() {
		return numerou4;
	}
	public void setNumerou4(int numerou4) {
		this.numerou4 = numerou4;
	}
	public String getSignou() {
		return signou;
	}
	public void setSignou(String signou) {
		this.signou = signou;
	}
	
	
	

}
