package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import org.json.simple.parser.ParseException;

@ManagedBean
public class SeleccionJuegos{
	
	private ArrayList<Apostador> apostadores = new ArrayList<Apostador>();
	private ArrayList<Chance> chances = new ArrayList<Chance>();
	private ArrayList<BalotoBean> balotos = new ArrayList<BalotoBean>();
	private ArrayList<Loteria> loterias = new ArrayList<Loteria>();
	private ArrayList<Betplay> betplays = new ArrayList<Betplay>();
	private ArrayList<Superastro> superastros = new ArrayList<Superastro>();
	private ArrayList<Integer> cedulaApostadores = new ArrayList<Integer>();
	private ArrayList<Sede> sedes = new ArrayList<Sede>();
	private ArrayList<Integer> codigoSedes = new ArrayList<Integer>();
	
	
	public ArrayList<Superastro> getSuperastros() {
		return superastros;
	}

	public void setSuperastros(ArrayList<Superastro> superastros) {
		this.superastros = superastros;
	}

	public ArrayList<Betplay> getBetplays() {
		return betplays;
	}

	public void setBetplays(ArrayList<Betplay> betplays) {
		this.betplays = betplays;
	}

	public ArrayList<Loteria> getLoterias() {
		return loterias;
	}

	public void setLoterias(ArrayList<Loteria> loterias) {
		this.loterias = loterias;
	}

	public ArrayList<Sede> getSedes() {
		return sedes;
	}
	
	public ArrayList<BalotoBean> getBalotos() {
		return balotos;
	}

	public void setBalotos(ArrayList<BalotoBean> balotos) {
		this.balotos = balotos;
	}
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
	public ArrayList<Chance> getChances() {
		return chances;
	}
	public void setChances(ArrayList<Chance> chances) {
		this.chances = chances;
	}
	public void setSedes(ArrayList<Sede> sedes) {
		this.sedes = sedes;
	}
	public ArrayList<Apostador> getApostadores() {
		return apostadores;
	}
	public void setApostadores(ArrayList<Apostador> apostadores) {
		this.apostadores = apostadores;
	}
	public String registroApostador() {
		try {
			apostadores= ApostadorJSON.getJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "usuarios.xhtml";
	}
	public String registroSede() {
		try {
			sedes= SedeJSON.getJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sedes.xhtml";
	}
	
	
	public ArrayList<Integer> getCedulaApostadores() {
		return cedulaApostadores;
	}
	public void setCedulaApostadores(ArrayList<Integer> cedulaApostadores) {
		this.cedulaApostadores = cedulaApostadores;
	}
	public ArrayList<Integer> getCodigoSedes() {
		return codigoSedes;
	}
	public void setCodigoSedes(ArrayList<Integer> codigoSedes) {
		this.codigoSedes = codigoSedes;
	}
	public void ordenarCodigos() {
		
		try {
			sedes = SedeJSON.getJSON();
			apostadores = ApostadorJSON.getJSON();
			for (int i = 0; i < sedes.size(); i++) {
				codigoSedes.add(sedes.get(i).getCodigo());
			}
			for (int i = 0; i < apostadores.size(); i++) {
				cedulaApostadores.add(apostadores.get(i).getCedula());
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String registroChance() {
		try {
			chances= ChanceJSON.getJSON();
			ordenarCodigos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "chances.xhtml";
	}
	public String registroBaloto() {
		try {
			balotos= BalotoJSON.getJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "balotos.xhtml";
	}
	public String registroLoteria() {
		try {
			loterias= LoteriaJSON.getJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "loterias.xhtml";
	}
	public String registroBetplay() {
		try {
			betplays= BetplayJSON.getJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "betplays.xhtml";
	}
	public String registroSuperastro() {
		try {
			superastros= SuperastroJSON.getJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "superastros.xhtml";
	}
	
	public String volver() {
		return "registro.xhtml";
	}
	
	public String enviaLimpiarUsuario() {
		return "limpiarusuario.xhtml";
	}
	public String enviaLimpiarSede() {
		return "limpiarsede.xhtml";
	}
	public String enviaRegistros() {
		return "registros.xhtml";
	}
}
