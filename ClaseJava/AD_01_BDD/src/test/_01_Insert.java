package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _01_Insert {
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/bbdd";
		String user = "root";
		String pass = "";
		
		System.out.println("Probando Conexion");
		try (Connection conn = DriverManager.getConnection(url, user, pass);){
			System.out.println("Conexion ha sido establecida");
			
			String query = "INSERT INTO personas (NOMBRE,EDAD,PESO) VALUES " 
			 + "('Antoñanzas',123,97)";
			Statement stmt = conn.createStatement();
			int rows = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
