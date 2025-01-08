package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidad.Coche;
import modelo.persistencia.interfaces.DaoCocheInterface;

public class DaoCoche implements DaoCocheInterface {
	String url = "jdbc:mysql://127.0.0.1:3306/bbdd";
	String user = "root";
	String pass = "";
	private static final Scanner sc = new Scanner(System.in);
	
	@Override
	public String darAlta(String marca, String modelo, String tipoMotor, int kilometros) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				){
			
			String query = "INSERT INTO coches (MARCA,MODELO,TIPOMOTOR, KILOMETROS) VALUES " 
					 + "(?,?,?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, marca);
			ps.setString(2, modelo);
			ps.setString(3, tipoMotor);
			ps.setInt(4, kilometros);
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				return "Coche Guardado";
			}
			return "No se ha agregado";
		}catch(Exception e) {
			return "Error";
			
		}
	}
	@Override
	public String darDeBaja(int id) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				){
			
			String query = "DELETE FROM coches WHERE id=? ";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, id);
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				return "Coche Borrado";
			}
			return "No se ha borrado ningun coche";
		}catch(Exception e) {
			return "Error";
			
		}
	}
	
	@Override
	public String modificarPorID(String marca, String modelo, String tipoMotor, int kilometros, int id) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				){
			
			String query = "UPDATE coches SET MARCA=?,MODELO=?,TIPOMOTOR=?, KILOMETROS=? WHERE id=? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, marca);
			ps.setString(2, modelo);
			ps.setString(3, tipoMotor);
			ps.setInt(4, kilometros);
			ps.setInt(5, id);
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				return "Coche Actualizado";
			}
			return "No se ha actualizado ningun coche";
		}catch(Exception e) {
			return "Error";
			
		}
	}
	@Override
	public Coche buscarPorID(int id) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				){
			
			String query = "SELECT * FROM coches WHERE id=? ";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Coche c = new Coche();
				int idCoche = rs.getInt(1);
				String marca = rs.getString(2);
				String modelo = rs.getString(3);
				String tipoMotor = rs.getString(4);
				int kilometros = rs.getInt(5);
				c.setId(idCoche);
				c.setKilometros(kilometros);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setTipoMotor(tipoMotor);
				return c;
			}
			return null;
		}catch(Exception e) {
			return null;
			
		}
	}
	@Override
	public Coche buscarPorMarca(String marcaa) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);
			){
			
			String query = "SELECT * FROM coches WHERE marca=? ";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, marcaa);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Coche c = new Coche();
				int idCoche = rs.getInt(1);
				String marca = rs.getString(2);
				String modelo = rs.getString(3);
				String tipoMotor = rs.getString(4);
				int kilometros = rs.getInt(5);
				c.setId(idCoche);
				c.setKilometros(kilometros);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setTipoMotor(tipoMotor);
				return c;
			}
			return null;
		}catch(Exception e) {
			return null;
			
		}
	}
	@Override
	public List<Coche> listarCoches() {
		List<Coche> listaCoches = new ArrayList<Coche>();
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				){
			
			
			String query = "SELECT * FROM coches";
			PreparedStatement ps = conn.prepareStatement(query);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Coche c = new Coche();
				int idCoche = rs.getInt(1);
				String marca = rs.getString(2);
				String modelo = rs.getString(3);
				String tipoMotor = rs.getString(4);
				int kilometros = rs.getInt(5);
				c.setId(idCoche);
				c.setKilometros(kilometros);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setTipoMotor(tipoMotor);
				listaCoches.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listaCoches;
	}
}
