package co.edu.unbosque.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardarApostadores {
	public static void main(String[]args) {
		SessionFactory miFactory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Beanapostadores.class)
				.buildSessionFactory();
		Session miSession=miFactory.openSession();
		try {
			Beanapostadores apostador1=new Beanapostadores("435353","Signo","fdgfsgfs","ghdgdh","gfgfdg");
			miSession.beginTransaction().commit();
			System.out.println("Registro Insertado!");
			miSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			miFactory.close();
		}
	}


}
