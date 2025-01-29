package es.kuhaku.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.kuhaku.entidad.Videojuego;

@Component
public class GestorVideojuego {
	@Autowired
	private DaoVideojuego daoVideojuego;
	
	    public boolean agregarVideojuego(Videojuego videojuego) {
	    	try {
	
	            if (videojuego.getNombre() == null || videojuego.getNombre().trim().isEmpty()) {
	                throw new IllegalArgumentException("El nombre del videojuego no puede estar en blanco.");
	            }
	            List<Videojuego> videojuegosConMismoNombre = daoVideojuego.listarVideojuegosPorNombre(videojuego.getNombre());

	            if (!videojuegosConMismoNombre.isEmpty()) {
	                throw new IllegalArgumentException("Ya existe un videojuego con el mismo nombre.");
	            }
	            
	            return daoVideojuego.agregarVideojuego(videojuego);
	    	}catch(Exception e) {
	    		return false;
	    	}
	    }

	    public boolean eliminarVideojuegoPorId(int id) {
	        return daoVideojuego.eliminarVideojuegoPorId(id);
	    }

	    public boolean modificarVideojuegoPorId(int id, Videojuego videojuego) {
	        return daoVideojuego.modificarVideojuegoPorId(id, videojuego);
	    }

	    public Videojuego obtenerVideojuegoPorId(int id) {
	        return daoVideojuego.obtenerVideojuegoPorId(id);
	    }

	    public List<Videojuego> listarTodosLosVideojuegos() {
	        return daoVideojuego.listarTodosLosVideojuegos();
	    }

	    public List<Videojuego> listarVideojuegosPorNombre(String nombre) {
	        return daoVideojuego.listarVideojuegosPorNombre(nombre);
	    }
	}


