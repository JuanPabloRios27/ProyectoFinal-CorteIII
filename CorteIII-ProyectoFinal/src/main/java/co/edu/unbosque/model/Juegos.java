package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Juegos {

	
	public String envialoteria() {
		return "loteria.xhtml";
	}
	public String enviabaloto() {
		return "baloto.xhtml";
	}
	public String enviaastro() {
		return "superastro.xhtml";
	}
	public String enviabetplay() {
		return "betplay.xhtml";
	}
	public String enviachance() {
		return "chance.xhtml";
	}
	public String volver() {
		return "registro.xhtml";
	}
}
