package co.edu.unbosque.model;

import java.io.IOException;

import javax.faces.bean.ManagedBean;

import org.json.simple.parser.ParseException;

@ManagedBean
public class Config {
	private String nombre;
	private int sedes;
	private int presupuesto;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSedes() {
		return sedes;
	}
	public void setSedes(int sedes) {
		this.sedes = sedes;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public String enviaConfig() {
		Config config = new Config();
		try {
			sedes = SedeJSON.getJSON().size();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		config.setNombre(nombre);
		config.setPresupuesto(presupuesto);
		config.setSedes(sedes);
		
		String link = "";
		
		int rta = 0;
		
		try {
			rta = ConfigJSON.postJSON(config);
			if(rta == 200) {
				link="seleccion.xhtml";
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
