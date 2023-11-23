package co.edu.unbosque.model;

import java.io.IOException;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class BalotoBean {
	
	private int codigo;
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private int num6;
	private int apuesta;
	private String dApuesta;
	
	private String rtaFactura;
	
	public String getRtaFactura() {
		return rtaFactura;
	}
	public void setRtaFactura(String rtaFactura) {
		this.rtaFactura = rtaFactura;
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
	
	
	public String envia() {
	
		Random random = new Random();
		codigo= random.nextInt(100)+1;
		apuesta= 20000;
		LocalDate fecha = LocalDate.now();
		String diaHoy = fecha.format(DateTimeFormatter.ofPattern("EEEE"));
		String textoNormalizado = Normalizer.normalize(diaHoy, Normalizer.Form.NFD);
	    Pattern patron = Pattern.compile("[^\\p{ASCII}]");
	    String today = patron.matcher(textoNormalizado).replaceAll("");
		dApuesta= today;
		BalotoBean ap = new BalotoBean();
		rtaFactura = "Baloto: " + num1 + " "+num2 + " "+num3 + " "+num4 + " "+num5 + " "+num6 + "\n";
		ap.setApuesta(apuesta);
		ap.setCodigo(codigo);
		ap.setNum1(num1);
		ap.setNum2(num2);
		ap.setNum3(num3);
		ap.setNum4(num4);
		ap.setNum5(num5);
		ap.setNum6(num6);
		ap.setdApuesta(dApuesta);
		int respuesta=0;
		String link="";
	
		try {
			respuesta = BalotoJSON.postJSON(ap);
			if(respuesta == 200) {
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
}
