package co.edu.unbosque.model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class usuarioDAO implements Operaciones{
	
	public ArrayList<usuario> ListaUsuario;
	
	public usuarioDAO() {
		
	}
	@Override
	public String crear() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String resultado;
				SessionFactory miFactory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(usuario.class)
						.buildSessionFactory();

				Session miSession = miFactory.openSession();
				try {
					miSession.beginTransaction();
					miSession.save((usuario)registro);
					miSession.getTransaction().commit();
					//System.out.println("Registro Insertado!");
					resultado = "OK";
					miSession.close();
				} catch (Exception e) {
					resultado = e.toString();
				} finally {
					miFactory.close();
				}
				return resultado;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
