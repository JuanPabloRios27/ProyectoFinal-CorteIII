package co.edu.unbosque.model;

import java.util.Random;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Loteria {
	private int numero1;
	private int numro2;
	private int numero3;
	private int numero4;
	private int numeroc1;
	private int numroc2;
	private int numeroc3;
	private int numeroc4;
	private int serie;
	private int seriec;
	
	
	public int getNumero1() {
		return numero1;
	}
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	public int getNumro2() {
		return numro2;
	}
	public void setNumro2(int numro2) {
		this.numro2 = numro2;
	}
	public int getNumero3() {
		return numero3;
	}
	public void setNumero3(int numero3) {
		this.numero3 = numero3;
	}
	public int getNumero4() {
		return numero4;
	}
	public void setNumero4(int numero4) {
		this.numero4 = numero4;
	}
	public int getNumeroc1() {
		return numeroc1;
	}
	public void setNumeroc1(int numeroc1) {
		this.numeroc1 = numeroc1;
	}
	public int getNumroc2() {
		return numroc2;
	}
	public void setNumroc2(int numroc2) {
		this.numroc2 = numroc2;
	}
	public int getNumeroc3() {
		return numeroc3;
	}
	public void setNumeroc3(int numeroc3) {
		this.numeroc3 = numeroc3;
	}
	public int getNumeroc4() {
		return numeroc4;
	}
	public void setNumeroc4(int numeroc4) {
		this.numeroc4 = numeroc4;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public int getSeriec() {
		return seriec;
	}
	public void setSeriec(int seriec) {
		this.seriec = seriec;
	}
	
	
	public String envia() {
		
		numeroc1=1;
		numroc2=2;
		numeroc3=3;
		numeroc4=4;
		seriec=999;
		String t1= numeroc1+"-"+numroc2+"-"+numeroc3+"-"+numeroc4+"-"+seriec+"";
		String h1= numero1+"-"+numro2+"-"+numero3+"-"+numero4+"-"+serie+"";
		
		if(t1.equals(h1)) {
			return "ganaste.xhtml";
		}else {
			return "perdiste.xhtml";
		}
		/*Random random= new Random();
		numeroc1=random.nextInt(45)+1;
		numroc2=random.nextInt(45)+1;
		numeroc3=random.nextInt(45)+1;
		numeroc4=random.nextInt(45)+1;
		*/
	}
}
