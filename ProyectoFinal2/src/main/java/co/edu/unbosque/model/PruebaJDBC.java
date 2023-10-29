package co.edu.unbosque.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebaJDBC {
	public static void main (String []args) {
		String cxString="jdbc:mysql://localhost:3306/Beans?serverTimezone=UTC&useSSL=false";
		String user="root";
		String pass="";
		try {
			System.out.println("Conectando por hibernate a bd..");
			Connection con=DriverManager.getConnection(cxString, user, pass);
			System.out.println("La Conexion es exitosa!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
