package co.edu.unbosque.model;

import java.util.Random;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Betplay {
	private String equipo1;
	private int resultado;
	private int resultadoc;
	
	
	public String getEquipo1() {
		return equipo1;
	}


	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}


	public int getResultado() {
		return resultado;
	}


	public void setResultado(int resultado) {
		this.resultado = resultado;
	}


	public int getResultadoc() {
		return resultadoc;
	}


	public void setResultadoc(int resultadoc) {
		this.resultadoc = resultadoc;
	}


	public String enviar() {
		Random r= new Random();
		resultadoc=r.nextInt(3)+1;;
		if(resultado==resultadoc) {
			return "ganaste.xhtml";
		}else {
			return "perdiste.xhtml";
		}
		
	}
}
