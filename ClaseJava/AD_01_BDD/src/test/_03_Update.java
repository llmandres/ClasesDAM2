package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class _03_Update {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try (Connection conn = DriverManager.getConnection(url, user, pass);){
			System.out.println("Conexion ha sido establecida");
			
			String query = "UPDATE personas SET NOMBRE=?,EDAD=?,PESO=? WHERE ID=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "DaniMuyGay87");
			ps.setInt(2, 28);
			ps.setDouble(3, 73);
			ps.setInt(4, 3);
			int rows = ps.executeUpdate();
			if(rows != 0) {
				System.out.println("Se ha modificado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
