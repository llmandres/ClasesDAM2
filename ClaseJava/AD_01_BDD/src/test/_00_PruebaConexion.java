package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _00_PruebaConexion {

	public static void main(String[] args) throws SQLException {
		// Puerto 3306 de MySQL
		// Archivo 10 de el workspace
		// protocolo:subprotocolo://IP:PUERTO/Esquema (la base de datos a la que vamos a acceder (nombre))
		String url = "jdbc:mysql://127.0.0.1:3306/bbdd";
		String user = "root";
		String pass = "";
		
		System.out.println("Probando Conexion");
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("Conexion ha sido establecida");
		conn.close();
		

	}

}
