package modelo.negocio;

import java.util.List;

import entidad.Pasajero;
import modelo.persistencia.DaoPasajero;

public class NegocioPasajero {
    private static DaoPasajero daoP = new DaoPasajero();
    
    // Definimos constantes para los códigos de respuesta
    private static final int SUCCESS = 1;
    private static final int FAILURE = 2;

    /**
     * Valida el alta de un pasajero.
     * 
     * @param nombre Nombre del pasajero
     * @param edad Edad del pasajero
     * @param peso Peso del pasajero
     * @return 1 si el alta es exitosa, 2 si no lo es.
     */
    public int validarAltaPasajero(String nombre, int edad, double peso){
        boolean flag = daoP.darAltaPasajero(nombre, edad, peso);
        if(flag) {
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    /**
     * Valida la baja de un pasajero.
     * 
     * @param id ID del pasajero
     * @return 1 si la baja es exitosa, 2 si no lo es.
     */
    public int validarBajaPasajero(int id){
        if(daoP.darDeBajaPasajero(id)) {
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    /**
     * Busca un pasajero por su ID.
     * 
     * @param id ID del pasajero
     * @return El pasajero si se encuentra, null si no.
     */
    public Pasajero buscarPasajeroPorId(int id){
        Pasajero p = daoP.consultarPasajero(id);
        if(p != null) {
            return p;
        } else {
            return null;
        }
    }

    /**
     * Lista todos los pasajeros.
     * 
     * @return Lista de pasajeros si existe, null si la lista está vacía o si hubo un error.
     */
    public List<Pasajero> listarPasajeros(){
        List<Pasajero> listaPasajeros = daoP.listarPasajeros();
        if(listaPasajeros != null) {
            return listaPasajeros;
        } else {
            return null;
        }
    }

    /**
     * Añade un pasajero a un coche.
     * 
     * @param idCoche ID del coche
     * @param idPasajero ID del pasajero
     * @return 1 si se añadió correctamente, 2 si no.
     */
    public int aniadirPasajeroaCoche(int idCoche, int idPasajero){
        if(daoP.añadirPasajeroACoche(idPasajero, idCoche)) {
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    /**
     * Elimina un pasajero de un coche.
     * 
     * @param idPasajero ID del pasajero
     * @return 1 si se eliminó correctamente, 2 si no.
     */
    public int eliminarPasajeroaCoche(int idPasajero){
        if(daoP.eliminarPasajeroCoche(idPasajero)) {
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    /**
     * Lista los pasajeros que están en un coche específico.
     * 
     * @param idCoche ID del coche
     * @return Lista de pasajeros si se encuentran, null si no hay pasajeros o hubo un error.
     */
    public List<Pasajero> listarPasajeroDeCoche(int idCoche){
        List<Pasajero> listaPasajerosEnCoche = daoP.listarPasajerosDeCoche(idCoche);
        if(listaPasajerosEnCoche != null) {
            return listaPasajerosEnCoche;
        } else {
            return null;
        }
    }
}