package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Reregistro{

	public String enviaUsuario() {
		return "registro.xhtml";
	}
	
	public String enviaSede() {	
		return "sede.xhtml";
	}

	public String enviaConfig() {
		return "configuracion.xhtml";
	}
}
