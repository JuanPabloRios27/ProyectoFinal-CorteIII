package co.edu.unbosque.model;

import java.io.IOException;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Juegos {

	private String nombre;
	private String tipo;
	private String pres;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPres() {
		return pres;
	}
	public void setPres(String pres) {
		this.pres = pres;
	}
	public String envia() {
		String link="";
		Juegos ju = new Juegos();
		ju.setNombre(nombre);
		ju.setTipo(tipo);
		ju.setPres(pres);
		
		int respuesta = 0;
		try {
			respuesta = JuegosJSON.postJSON(ju);
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
