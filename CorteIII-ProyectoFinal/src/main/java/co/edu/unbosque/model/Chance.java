package co.edu.unbosque.model;

import java.util.Random;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Chance {
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	
	private int numc1;
	private int numc2;
	private int numc3;
	private int numc4;
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
	public int getNumc1() {
		return numc1;
	}
	public void setNumc1(int numc1) {
		this.numc1 = numc1;
	}
	public int getNumc2() {
		return numc2;
	}
	public void setNumc2(int numc2) {
		this.numc2 = numc2;
	}
	public int getNumc3() {
		return numc3;
	}
	public void setNumc3(int numc3) {
		this.numc3 = numc3;
	}
	public int getNumc4() {
		return numc4;
	}
	public void setNumc4(int numc4) {
		this.numc4 = numc4;
	}
	
	public String envia() {
	Random random= new Random();
		numc1=random.nextInt(100)+1;
		numc2=random.nextInt(100)+1;
		numc3=random.nextInt(100)+1;
		numc4=random.nextInt(100)+1;
		
		String h= numc1+"-"+numc2+"-"+numc3+"-"+numc4;
		String t= num1+"-"+num2+"-"+num3+"-"+num4;
		
		if(h.equals(t)) {
			return "ganaste.xhtml";
		}else {
			return "perdiste.xhtml";
		}
		
	}
}
