package modelo.persistencia.interfaces;

import java.util.List;

import entidad.Coche;

public interface DaoCocheInterface  {
	
	public boolean darAlta(String marca, String modelo, int anioFabricacion, int kilometros);
	public boolean darDeBaja(int id);
	public boolean modificarPorID(String marca, String modelo, int anioFabricacion, int kilometros, int id);
	public Coche buscarPorID(int id);
	public List<Coche> listarCoches();

}
