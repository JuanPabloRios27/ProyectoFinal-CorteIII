package co.edu.unbosque.model;

import java.io.IOException;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Betplay {
	private int codigo;
	private String partido;
	private int resultado;
	private String dApuesta;
	private int apuesta;
	
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public String getdApuesta() {
		return dApuesta;
	}
	public void setdApuesta(String dApuesta) {
		this.dApuesta = dApuesta;
	}

	public String enviar() {
		String link = "";
		
		Random random= new Random();
		apuesta=20000;
		Betplay c = new Betplay();
		c.setCodigo(random.nextInt(100)+1);
		c.setPartido(this.partido);
		c.setResultado(this.resultado);
		c.setdApuesta(this.dApuesta);
		c.setApuesta(this.apuesta);
		
		rtaFactura = "Betplay: "+partido+" "+"resultado del partido: "+" "+resultado+"\n";
		
		int rta = 0;
		
		try {
			rta = BetplayJSON.postJSON(c);
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
}
