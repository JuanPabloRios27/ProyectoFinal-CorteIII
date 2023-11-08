package co.edu.unbosque.model;

import java.util.Random;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Superastro {
	private int numerou1;
	private int numerou2;
	private int numerou3;
	private int numerou4;
	private int numeroc1;
	private int numeroc2;
	private int numeroc3;
	private int numeroc4;
	private String signou;
	private String signoc;
	private boolean premio;
	private String g;
	private String t;
	public int getNumerou1() {
		return numerou1;
	}
	public void setNumerou1(int numerou1) {
		this.numerou1 = numerou1;
	}
	public int getNumeroc1() {
		return numeroc1;
	}
	public void setNumeroc1(int numeroc1) {
		this.numeroc1 = numeroc1;
	}
	public String getSignou() {
		return signou;
	}
	public void setSignou(String signou) {
		this.signou = signou;
	}
	public String getSignoc() {
		return signoc;
	}
	public void setSignoc(String signoc) {
		this.signoc = signoc;
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
	public int getNumeroc2() {
		return numeroc2;
	}
	public void setNumeroc2(int numeroc2) {
		this.numeroc2 = numeroc2;
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
	
	public boolean isPremio() {
		return premio;
	}
	public void setPremio(boolean premio) {
		this.premio = premio;
	}
	
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String envia() {
		Random random = new Random();
		
		numeroc1 = random.nextInt(10);
		numeroc2 = random.nextInt(10);
		numeroc3 = random.nextInt(10);
		numeroc4 = random.nextInt(10);
		
		
		int y= random.nextInt(12)+1;
		signoc=Integer.toString(y);
		g=numeroc1+"-"+numeroc2+"-"+numeroc3+"-"+numeroc4+"-"+signoc;
		t=numerou1+"-"+numerou2+"-"+numerou3+"-"+numerou4+"-"+signou;
		
		if(g.equals(t)) {
			premio=true;
			return "ganaste.xhtml";
		}else {
			premio=false;
			return "perdiste.xhtml";
		}
		
		
		
	}
}
