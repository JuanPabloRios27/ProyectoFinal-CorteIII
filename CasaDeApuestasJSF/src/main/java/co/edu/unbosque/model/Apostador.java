package co.edu.unbosque.model;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.json.simple.parser.ParseException;

@SessionScoped
@ManagedBean
public 	class Apostador {
	
	private int cedula;
	private String nombre;
	private String sede;
	private String direccion;
	private int celular;
	
	private String msgFactura;
	
	
	public String getMsgFactura() {
		return msgFactura;
	}
	public void setMsgFactura(String msgFactura) {
		this.msgFactura = msgFactura;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public String limpiar() {
		try {		
			ApostadorJSON.eliminar(cedula);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "seleccion-apuesta.xhtml";
	}
	public String envia() {
		String link="";
		Apostador ap = new Apostador();
		ap.setNombre(nombre);
		ap.setCedula(cedula);
		ap.setDireccion(direccion);
		ap.setCelular(celular);
		ap.setSede(sede);
		int respuesta = 0;
		try {
			respuesta = ApostadorJSON.postJSON(ap);
			if(respuesta == 200) {
				link="seleccion-apuesta.xhtml";
			}else {
				link="perdiste.xhtml";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(ap.getNombre() + " = Test");
		
		return link;
	}
}
