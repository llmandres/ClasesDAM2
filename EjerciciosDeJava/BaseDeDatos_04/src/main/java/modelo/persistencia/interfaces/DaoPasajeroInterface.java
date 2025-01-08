package modelo.persistencia.interfaces;

import java.util.List;

import entidad.Pasajero;

public interface DaoPasajeroInterface {
	public boolean darAltaPasajero(String nombre, int edad, double peso);
	public boolean darDeBajaPasajero(int id);
	public Pasajero consultarPasajero(int id);
	public List<Pasajero> listarPasajeros();
	public boolean añadirPasajeroACoche(int idPasajero, int idCoche);
	public boolean eliminarPasajeroCoche(int idPasajero);
	public List<Pasajero> listarPasajerosDeCoche(int idCoche);
	

}
