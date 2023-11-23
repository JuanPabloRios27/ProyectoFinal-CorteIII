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
public class Loteria {
	private int numero1;
	private int numero2;
	private int numero3;
	private int numero4;
	private int codigo;
	private int serie;
	private int apuesta;
	private String dApuesta;
	
	private String rtaFactura;
	
	public String getRtaFactura() {
		return rtaFactura;
	}

	public void setRtaFactura(String rtaFactura) {
		this.rtaFactura = rtaFactura;
	}

	public int getNumero1() {
		return numero1;
	}
	
	public String getdApuesta() {
		return dApuesta;
	}

	public void setdApuesta(String dApuesta) {
		this.dApuesta = dApuesta;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	public int getNumero2() {
		return numero2;
	}
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
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
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	
	public int getApuesta() {
		return apuesta;
	}
	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
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
		Loteria ap = new Loteria();
		ap.setApuesta(apuesta);
		ap.setCodigo(codigo);
		ap.setNumero1(numero1);
		ap.setNumero2(numero2);
		ap.setNumero3(numero3);
		ap.setNumero4(numero4);
		ap.setSerie(serie);
		ap.setdApuesta(dApuesta);
		
		rtaFactura="Loteria: " + numero1 + " "+numero2 + " "+numero3 + " "+numero4 + " "+serie+"\n";
		
		int respuesta=0;
		String link="";
	
		try {
			respuesta = LoteriaJSON.postJSON(ap);
			if(respuesta == 200) {
				link="seleccion-apuesta.xhtml";
			}else {
				link="perdiste.xhtml";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(ap.getApuesta() + " = Test");
		
		return link;
		
		
	}
}
