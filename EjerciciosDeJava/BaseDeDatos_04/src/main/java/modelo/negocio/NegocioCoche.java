package modelo.negocio;

import modelo.persistencia.DaoCoche;

import java.util.List;

import entidad.Coche;

public class NegocioCoche {
	private static DaoCoche daoC = new DaoCoche();
	
	/**
	 * Valida los datos del coche antes de ser dado de alta
	 * @param marca Marca del coche
	 * @param modelo Modelo del coche
	 * @param anioFabricacion Año de fabricacion del coche
	 * @param kilometros Kilometros recorridos del coche
	 * @return
	 * - 1 -> En caso de que la marca o el modelo este vacio
	 * - 2 -> Si el coche se ha guardado correctamente.
	 * - 0 -> Si ha ocurrido un error y no se ha guardado
	 */
	public int validarAlta(String marca, String modelo, int anioFabricacion, int kilometros) {
		boolean flag = daoC.darAlta(marca, modelo, anioFabricacion, kilometros);
		if(marca.isEmpty() || modelo.isEmpty()) {
			return 1;
		}else if(flag){
		return 2;
		}else {
			return 0;
		}
	}
	/**
	 * 
	 * @param idcoche Id del coche a dar de baja
	 * @return
	 * - 2 -> En caso de que el coche sea dado de baja correctamente.
	 * - 0 -> El coche no se ha borrado correctamente.
	 */
	public int validarBaja(int idcoche) {
		if(daoC.darDeBaja(idcoche)){
		return 2;
		}else {
			return 0;
		}
	}
	/**
	 * 
	 * @param marca Marca del coche
	 * @param modelo Modelo del coche
	 * @param anioFabricacion Año de fabricacion del coche
	 * @param kilometros Kilometros recorridos del coche
	 * @param id del coche que vaya a ser actualizado
	 * @return
	 * - 2 -> En caso de que sea modificado correctamente.
	 * - 0 -> En caso de que el coche no se haya modificado correctamente.
	 */
	public int modificarPorID(String marca, String modelo, int anioFabricacion, int kilometros, int id) {
		if(daoC.modificarPorID(marca, modelo, anioFabricacion, kilometros, id)){
			return 2;
		}else {
			return 0;
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 * - NULL -> El coche no se ha encontrado
	 * - C1 -> Si se devuelve un objeto si se ha encontrado
	 */
	public Coche buscarPorId(int id) {
		Coche c1 = daoC.buscarPorID(id);
		if(c1 == null){
			return null;
		}else {
			return c1;
		}
	}
	public List<Coche> listarCoches() {
		List<Coche> listaCoche = daoC.listarCoches();
		if(listaCoche == null){
			return null;
		}else {
			return listaCoche;
		}
	}

}
