package modelo.negocio;

import java.io.IOException;
import java.util.ArrayList;

import modelo.entidad.Videojuego;
import modelo.persistencia.DaoVideojuegoFichero;

public class GestorVideojuego {
	private DaoVideojuegoFichero dv;

	/**
	 * Método que valida un videojuego pasado por parametro contra un videojuego
	 * guardado en la persistencia. Un videojuego esta validado cuando el nombre
	 * guardado coincide con el Videojuego pasado por parametro.
	 * 
	 * @param v Videojuego a comparar
	 * @return <b>0</b> el Videojuego no existe, <b>1</b> el Videojuego existe y es
	 *         valido, <b>2</b> el Videojuego existe pero no es valido y <b>404</b>
	 *         en caso de que haya algún problema en el de entrada salida
	 */
	public int validarVideojuego(Videojuego v, String archivo) {
		dv = new DaoVideojuegoFichero();
		try {
			Videojuego vFichero = dv.getByName(v.getNombre(), archivo);
			if (vFichero == null) {
				return 0;
			}

			if (vFichero.equals(v)) {
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			return 404;
		}
	}

	/**
	 * Método que guarda un Videojuego pasado por parametro
	 * 
	 * @param v el Videojuego a guardar
	 * @return <b>0</b> el Videojuego pasado por parametro es null, <b>1</b> el
	 *         nombre esta vacio o tiene menos de 3 caracteres, <b>2</b> la compania
	 *         esta vacio o tiene menos de 5 caracteres , <b>3</b> el Videojuego se
	 *         ha guardado <b>4</b> La nota del videojuego no esta en el rango de 0
	 *         a 100 <b>404</b> en caso de que haya algún problema en el de entrada
	 *         salida
	 */
	public int guardar(Videojuego v, String archivo) {
		if (v == null) {
			return 0;
		}

		dv = new DaoVideojuegoFichero();
		try {
			if (v.getNombre().isBlank() || v.getNombre().length() < 3) {
				return 1;
			} else if (v.getCompania().isBlank() || v.getCompania().length() < 5) {
				return 2;
			} else if (v.getNota() < 0 || v.getNota() > 100) {
				return 4;
			} else {
				dv.register(v, archivo);
				return 3;
			}
		} catch (Exception e) {
			return 500;
		}
	}
	/**
	 * Metodo que muestra una lista de los videojuegos existentes y persistentes en el fichero
	 * @return Devuelve un arrayList de videojuegos
	 * @throws Exception Error en el fichero
	 */
	public ArrayList<Videojuego> listarVideojuego(String archivo) throws Exception {
		dv = new DaoVideojuegoFichero();

		return dv.listarVideojuego(archivo);
	}

	
		/**
		 * Método que elimina dicho videojuego pasado por parametro
		 * @param v Nombre del videojuego persistente a borrar
		 */
	public void eliminarVideojuego(String v, String archivo) {
		dv = new DaoVideojuegoFichero();
		try {
			dv.eliminarVideojuego(v, archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
