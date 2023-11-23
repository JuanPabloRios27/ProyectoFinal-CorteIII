package co.edu.unbosque.model;

import java.io.IOException;
import java.util.Random;

import javax.faces.bean.ManagedBean;

import org.json.simple.parser.ParseException;

@ManagedBean
public class Sede {
	
	private int codigo;
	private String nombre;
	private int nTrabajadores;
	private String afiliacion;
	
	public String getAfiliacion() {
		return afiliacion;
	}

	public void setAfiliacion(String afiliacion) {
		this.afiliacion = afiliacion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String menuRegistro() {
		
		return "registro.xhtml";
	}
	public String limpiar() {
		try {		
			SedeJSON.eliminar(codigo);	
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
		Sede ap = new Sede();
		Random rnd = new Random();
		ap.setCodigo(rnd.nextInt(100)+1);
		ap.setAfiliacion(afiliacion);
		ap.setNombre(afiliacion + " - " + nombre);
		ap.setnTrabajadores(nTrabajadores);
		int respuesta = 0;
		try {
			respuesta = SedeJSON.postJSON(ap);
			if(respuesta == 200) {
				link="seleccion-apuesta.xhtml";
			}else {
				link="perdiste.xhtml";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(ap.getNombre() + " = Test");
		return link;
	}

	public int getnTrabajadores() {
		return nTrabajadores;
	}

	public void setnTrabajadores(int nTrabajadores) {
		this.nTrabajadores = nTrabajadores;
	}
	
}
