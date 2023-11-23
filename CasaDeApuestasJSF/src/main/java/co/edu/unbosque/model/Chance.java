package co.edu.unbosque.model;

import java.io.IOException;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Chance {
	
	private int apuesta;
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private String dApuesta;
	private int codigo;
	
	private String rtaFactura;
	
	public String getRtaFactura() {
		return rtaFactura;
	}
	public void setRtaFactura(String rtaFactura) {
		this.rtaFactura = rtaFactura;
	}
	public int getApuesta() {
		return apuesta;
	}
	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}
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
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String envia() {
		String link = "";
		
		apuesta = 20000;
		Random random= new Random();
		Chance c = new Chance();
		c.setCodigo(random.nextInt(100)+1);
		c.setNum1(this.num1);
		c.setNum2(this.num2);
		c.setNum3(this.num3);
		c.setNum4(this.num4);
		c.setApuesta(apuesta);
		
		rtaFactura = "Chance: " + num1 + " " + num2 + " " + num3 + " " + num4 + "\n";
		
		int rta = 0;
		
		try {
			rta = ChanceJSON.postJSON(c);
			if(rta == 200) {
				link="seleccion-apuesta.xhtml";
			}else {
				link="perdiste.xhtml";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return link;
	}
	public String getdApuesta() {
		return dApuesta;
	}
	public void setdApuesta(String dApuesta) {
		this.dApuesta = dApuesta;
	}
}
