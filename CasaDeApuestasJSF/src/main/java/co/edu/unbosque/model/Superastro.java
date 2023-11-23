package co.edu.unbosque.model;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Superastro {
	private int codigo;
	private int apuesta;
	private String dApuesta;
	private int numerou1;
	private int numerou2;
	private int numerou3;
	private int numerou4;
	private String signou;
	
	private String rtaFactura;
	
	public String getRtaFactura() {
		return rtaFactura;
	}
	public void setRtaFactura(String rtaFactura) {
		this.rtaFactura = rtaFactura;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getdApuesta() {
		return dApuesta;
	}
	public void setdApuesta(String dApuesta) {
		this.dApuesta = dApuesta;
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
	public String envia() {
		String link = "";
		Random random = new Random();
		
		Superastro sp = new Superastro();
		sp.setCodigo(random.nextInt(100)+1);
		LocalDate fecha = LocalDate.now();
		String diaHoy = fecha.format(DateTimeFormatter.ofPattern("EEEE"));
		String textoNormalizado = Normalizer.normalize(diaHoy, Normalizer.Form.NFD);
	    Pattern patron = Pattern.compile("[^\\p{ASCII}]");
	    String today = patron.matcher(textoNormalizado).replaceAll("");
		sp.setdApuesta(today);
		apuesta = 20000;
		sp.setApuesta(apuesta);
		sp.setNumerou1(numerou1);
		sp.setNumerou2(numerou2);
		sp.setNumerou3(numerou3);
		sp.setNumerou4(numerou4);
		sp.setSignou(signou);
		
		rtaFactura = "Superastro: " + numerou1 + ""+ numerou2 + ""+ numerou3 + ""+ numerou4 + " Signo"+ signou + "\n";
		
		return link;
	}
	public int getApuesta() {
		return apuesta;
	}
	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}
}
