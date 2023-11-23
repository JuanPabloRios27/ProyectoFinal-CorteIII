package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class ProcesamientoFacturas {
	
	@ManagedProperty(value="#{balotoBean}")
	private BalotoBean baloto = new BalotoBean();
	@ManagedProperty(value="#{chance}")
	private Chance chance = new Chance();
	@ManagedProperty(value="#{betplay}")
	private Betplay betplay = new Betplay();
	@ManagedProperty(value="#{superastro}")
	private Superastro astro = new Superastro();
	@ManagedProperty(value="#{loteria}")
	private Loteria lot = new Loteria();
	@ManagedProperty(value="#{apostador}")
	private Apostador ap = new Apostador();
	
	private String nombre;
	private int cedula;
	private String sede;
	private String direccion;
	private int celular;
	
	private String rta = "";
	private int costoTotal;
	
	
	public Apostador getAp() {
		return ap;
	}
	public void setAp(Apostador ap) {
		this.ap = ap;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
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
	public int getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}
	public String getRta() {
		return rta;
	}
	public void setRta(String rta) {
		this.rta = rta;
	}
	public void añadirCosto(int adicion) {
		costoTotal+=adicion;
	}
	
	public BalotoBean getBaloto() {
		return baloto;
	}
	public void setBaloto(BalotoBean baloto) {
		this.baloto = baloto;
	}
	public Chance getChance() {
		return chance;
	}
	public void setChance(Chance chance) {
		this.chance = chance;
	}
	
	public Superastro getAstro() {
		return astro;
	}
	public void setAstro(Superastro astro) {
		this.astro = astro;
	}
	public Betplay getBetplay() {
		return betplay;
	}
	public void setBetplay(Betplay betplay) {
		this.betplay = betplay;
	}
	public Loteria getLot() {
		return lot;
	}
	public void setLot(Loteria lot) {
		this.lot = lot;
	}
	public String procesarInformacion() {
		cedula= ap.getCedula();
        nombre= ap.getNombre();
        celular= ap.getCelular();
        sede= ap.getSede();
        direccion= ap.getDireccion();
		
        String informacionBaloto = baloto.getRtaFactura();
        String informacionChance = chance.getRtaFactura();
        String informacionSuperastro = astro.getRtaFactura();
		String informacionBetplay= betplay.getRtaFactura();
		String informacionLoteria= lot.getRtaFactura();

        
        if(informacionChance!=null&&informacionChance!="") {
            this.rta+= informacionChance;
            this.costoTotal+=chance.getApuesta();
        }
        if(informacionBaloto!=null&&informacionBaloto!="") {
        	this.costoTotal+=baloto.getApuesta();
        	this.rta+= informacionBaloto;
        }
        if(informacionSuperastro!=null&&informacionSuperastro!="") {
        	this.costoTotal+=astro.getApuesta();
        	this.rta+= informacionSuperastro;
        }
        if(informacionBetplay!=null&&informacionBetplay!="") {
			this.costoTotal+=betplay.getApuesta();
			this.rta+= informacionBetplay;
		}
		if(informacionLoteria!=null&&informacionLoteria!="") {
			this.costoTotal+=lot.getApuesta();
			this.rta+= informacionLoteria;
		}
		this.rta+="\nCosto Total: " + this.costoTotal;
        return "factura.xhtml";
    }
}
