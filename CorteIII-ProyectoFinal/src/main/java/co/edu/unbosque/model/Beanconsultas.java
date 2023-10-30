package co.edu.unbosque.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="apuestas-chance")
@ManagedBean
public class Beanconsultas {
	private String listaclientes;
	private int valortotal;
	

}
