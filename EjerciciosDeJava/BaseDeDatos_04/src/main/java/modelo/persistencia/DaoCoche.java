package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.AppConfig;
import entidad.Coche;
import modelo.persistencia.interfaces.DaoCocheInterface;

public class DaoCoche implements DaoCocheInterface {
	private static AppConfig ac = new AppConfig();

    private  String url = ac.getProperty("db.url");
    private  String user = ac.getProperty("db.user");
    private  String pass = ac.getProperty("db.password");
	
	private static final Scanner sc = new Scanner(System.in);
	
	@Override
	public boolean darAlta(String marca, String modelo, int anioFabricacion, int kilometros) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				){
			
			String query = "INSERT INTO coches (MARCA,MODELO,anioFabricacion, KILOMETROS) VALUES " 
					 + "(?,?,?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, marca);
			ps.setString(2, modelo);
			ps.setInt(3, anioFabricacion);
			ps.setInt(4, kilometros);
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				return true;
			}
			return false;
		}catch(Exception e) {
			return false;
			
		}
	}
	@Override
	public boolean darDeBaja(int id) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				){
			
			String query = "DELETE FROM coches WHERE id=? ";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, id);
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
			
		}
	}
	
	@Override
	public boolean modificarPorID(String marca, String modelo, int anioFabricacion, int kilometros, int id) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				){
			
			String query = "UPDATE coches SET MARCA=?,MODELO=?,anioFabricacion=?, KILOMETROS=? WHERE id=? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, marca);
			ps.setString(2, modelo);
			ps.setInt(3, anioFabricacion);
			ps.setInt(4, kilometros);
			ps.setInt(5, id);
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
			
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
				int anioFrabricacion = rs.getInt(4);
				int kilometros = rs.getInt(5);
				c.setId(idCoche);
				c.setKilometros(kilometros);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setAnioFabricacion(anioFrabricacion);
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
				int anioFrabricacion = rs.getInt(4);
				int kilometros = rs.getInt(5);
				c.setId(idCoche);
				c.setKilometros(kilometros);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setAnioFabricacion(anioFrabricacion);
				listaCoches.add(c);
			}
		}catch(Exception e) {
			return null;
		}
		return listaCoches;
	}
}
