package modelo.persistencia.interfaces;

import java.util.List;

import entidad.Coche;

public interface DaoCocheInterface  {
	
	public String darAlta(String marca, String modelo, String tipoMotor, int kilometros);
	public String darDeBaja(int id);
	public String modificarPorID(String marca, String modelo, String tipoMotor, int kilometros, int id);
	public Coche buscarPorID(int id);
	public Coche buscarPorMarca(String marca);
	public List<Coche> listarCoches();

}
