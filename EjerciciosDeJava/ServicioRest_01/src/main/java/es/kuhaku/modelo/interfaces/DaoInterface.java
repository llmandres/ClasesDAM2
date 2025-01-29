package es.kuhaku.modelo.interfaces;

import es.kuhaku.entidad.Videojuego;
import java.util.List;

public interface DaoInterface {

    boolean agregarVideojuego(Videojuego v);
    boolean eliminarVideojuegoPorId(int id);
    boolean modificarVideojuegoPorId(int id, Videojuego v);
    Videojuego obtenerVideojuegoPorId(int id);
    List<Videojuego> listarTodosLosVideojuegos();
    List<Videojuego> listarVideojuegosPorNombre(String nombre);
}
