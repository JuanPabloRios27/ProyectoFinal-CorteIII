package co.edu.unbosque.model;

import java.util.Random;

import javax.annotation.ManagedBean;

@ManagedBean
public class BalotoBean {
	
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private int num6;
	
	private int rta1;
	private int rta2;
	private int rta3;
	private int rta4;
	private int rta5;
	private int rta6;
	
	private String ganar;
	private String respuesta;
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getNum3() {
		return num3;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	public int getNum4() {
		return num4;
	}
	public void setNum4(int num4) {
		this.num4 = num4;
	}
	public int getNum5() {
		return num5;
	}
	public void setNum5(int num5) {
		this.num5 = num5;
	}
	public int getNum6() {
		return num6;
	}
	public void setNum6(int num6) {
		this.num6 = num6;
	}
	public int getRta1() {
		return rta1;
	}
	public void setRta1(int rta1) {
		this.rta1 = rta1;
	}
	public int getRta2() {
		return rta2;
	}
	public void setRta2(int rta2) {
		this.rta2 = rta2;
	}
	public int getRta3() {
		return rta3;
	}
	public void setRta3(int rta3) {
		this.rta3 = rta3;
	}
	public int getRta4() {
		return rta4;
	}
	public void setRta4(int rta4) {
		this.rta4 = rta4;
	}
	public int getRta5() {
		return rta5;
	}
	public void setRta5(int rta5) {
		this.rta5 = rta5;
	}
	public int getRta6() {
		return rta6;
	}
	public void setRta6(int rta6) {
		this.rta6 = rta6;
	}
	public String getGanar() {
		return ganar;
	}
	public void setGanar(String ganar) {
		this.ganar = ganar;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String envia() {
		Random rnd = new Random();
		
		
		rta1 = rnd.nextInt(45)+1;
		rta2 = rnd.nextInt(45)+1;
		rta3 = rnd.nextInt(45)+1;
		rta4 = rnd.nextInt(45)+1;
		rta5 = rnd.nextInt(45)+1;
		rta6 = rnd.nextInt(45)+1;
		
		ganar = rta1 + "-" + rta2+ "-" + rta3+ "-" + rta4+ "-" + rta5+ "-" + rta6;
		respuesta = num1 + "-" + num2+ "-" + num3+ "-" + num4+ "-" + num5+ "-" + num6;
		
		if(ganar.equals(respuesta)) {
			return"ganaste.xhtml";
		}else { return"perdiste.xhtml";}
		
	}
}
