package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _05_SelectByName {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try (Connection conn = DriverManager.getConnection(url, user, pass);){
			System.out.println("Conexion ha sido establecida");
			
			// Las interrogantes, son por orden, es decir abajo
			
			String query = "SELECT * FROM personas WHERE nombre=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			// Este 1, es la primera interrogante que sale, es decir la de nombre:?
			ps.setString(1, "Antoñanzas");

			ResultSet rs = ps.executeQuery();
			// El .next devuelve true o false, es decir si NO hay next, se acaba
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				int edad = rs.getInt(3);
				double peso = rs.getDouble(4);
				System.out.println("Registro: " + id + " " + nombre + " " + edad + " " + peso);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
