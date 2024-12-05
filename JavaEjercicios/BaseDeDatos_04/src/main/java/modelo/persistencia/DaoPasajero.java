package modelo.persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import config.AppConfig;
import entidad.Coche;
import entidad.Pasajero;
import modelo.persistencia.interfaces.DaoPasajeroInterface;

public class DaoPasajero implements DaoPasajeroInterface {
	private static AppConfig ac = new AppConfig();

    private  String url = ac.getProperty("db.url");
    private  String user = ac.getProperty("db.user");
    private  String pass = ac.getProperty("db.password");
    
	
    @Override
    public boolean darAltaPasajero(String nombre, int edad, double peso) {
        String query = "INSERT INTO pasajero (nombre, edad, peso) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setDouble(3, peso);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean darDeBajaPasajero(int id) {
        String query = "DELETE FROM pasajero WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Pasajero consultarPasajero(int id) {
        String query = "SELECT * FROM pasajero WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Pasajero p = new Pasajero();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setEdad(rs.getInt("edad"));
                p.setPeso(rs.getDouble("peso"));
                return p;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Pasajero> listarPasajeros() {
        List<Pasajero> listaPasajeros = new ArrayList<>();
        String query = "SELECT * FROM pasajero";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pasajero p = new Pasajero();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setEdad(rs.getInt("edad"));
                p.setPeso(rs.getDouble("peso"));
                listaPasajeros.add(p);
            }
            return listaPasajeros;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean añadirPasajeroACoche(int idPasajero, int idCoche) {
        String query = "UPDATE pasajero SET id_coche = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, idCoche);
            ps.setInt(2, idPasajero);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarPasajeroCoche(int idPasajero) {
        String query = "UPDATE pasajero SET id_coche = NULL WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, idPasajero);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Pasajero> listarPasajerosDeCoche(int idCoche) {
        List<Pasajero> listaPasajerosCoches = new ArrayList<>();
        String query = "SELECT * FROM pasajero WHERE id_coche = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, idCoche);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pasajero p = new Pasajero();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setEdad(rs.getInt("edad"));
                p.setPeso(rs.getDouble("peso"));
                listaPasajerosCoches.add(p);
            }
            return listaPasajerosCoches;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


