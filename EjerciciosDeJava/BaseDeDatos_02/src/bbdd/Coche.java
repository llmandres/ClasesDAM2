package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Coche {
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/bbdd";
		String user = "root";
		String pass = "";
		
		System.out.println("Probando Conexion");
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				Scanner sc = new Scanner(System.in);){

			System.out.println("Conexion ha sido establecida");
			 // id, una marca, un modelo, un tipo de motor y unos kilómetros.
			String query = "INSERT INTO coches (MARCA,MODELO,TIPOMOTOR, KILOMETROS) VALUES " 
			 + "(?,?,?, ?)";
			boolean repetir = false;
			PreparedStatement ps = conn.prepareStatement(query);
			do {
			System.out.println("Introduce la Marca del coche");
			ps.setString(1, establecerValorString(sc));
			System.out.println("Introduce el Modelo del coche");
			ps.setString(2, establecerValorString(sc));
			System.out.println("Introduce el tipo del motor del coche");
			ps.setString(3, establecerValorString(sc));
			System.out.println("Introduce el numero de kilometros del coche");
			ps.setInt(4, establecerValorInteger(sc));
			int rows = ps.executeUpdate();
			if(rows != 0) {
				System.out.println("Cambios Guardados");
			}
			int opcion = 0;
			do {
			System.out.println("Quieres añadir otro coche?");
			System.out.println("1. Si");
			System.out.println("2. No");
			opcion = Integer.parseInt(sc.nextLine());
			if(opcion == 1) {
				repetir = true;
			}else if(opcion == 2) {
				repetir = false;
				break;
			}else {
				System.out.println("Opcion Erronea");
			}
			}while(opcion != 1);
			}while(repetir);
		

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	public static String establecerValorString(Scanner sc) {
		boolean rep = false;
		String string = null;
		do {
			 string = sc.nextLine();
			if(string.isBlank() || string.isBlank()){
				rep = true;
				System.out.println("Introduce un valor");
			}else {
				rep = false;
			}
		}while(rep);
		return string;
	}
	public static int establecerValorInteger(Scanner sc) {
		boolean rep = false;
		String string = null;
		int numero = 0;
		do {
			 string = sc.nextLine();
			if(string.isBlank() || string.isEmpty()){
				rep = true;
				System.out.println("Introduce un valor");
			}else {
				rep = false;
			}
		}while(rep);
		numero = Integer.parseInt(string);
		return numero;
	}
}
