package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _06_DELETE {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try (Connection conn = DriverManager.getConnection(url, user, pass);){
			System.out.println("Conexion ha sido establecida");
			
			// Las interrogantes, son por orden, es decir abajo
			
			String query = "DELETE FROM personas WHERE ID=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			// Este 1, es la primera interrogante que sale, es decir la de nombre:?
			ps.setInt(1, 1);

			// El .next devuelve true o false, es decir si NO hay next, se acaba
			int filas = ps.executeUpdate();
			if(filas == 1) {
				System.out.println("Hemos borrado a ID 1");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
