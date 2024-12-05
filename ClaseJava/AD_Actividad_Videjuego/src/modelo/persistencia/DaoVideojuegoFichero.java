package modelo.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Videojuego;

public class DaoVideojuegoFichero {
	private static final String NOMBRE_FICHERO = "videojuegos.txt";

	/**
	 * Método que dado un videojuego por parámetro busca su coincidencia en el
	 * fichero "videojuegos.txt" y en caso de que lo encuentre, lo devuelve junto
	 * con su nota y su compañía
	 * 
	 * @param videojuego el videojuego a buscar en el fichero
	 * @return videojuego en el caso de que esté en el fichero o null en caso
	 *         contrario
	 * @throws Excepcion en caso de que haya algún problema en el fichero de texto
	 */

	public Videojuego getByName(String videojuego, String nombreFichero) throws Exception {
	    Videojuego v = null;
	    try (FileReader fr = new FileReader(nombreFichero); BufferedReader br = new BufferedReader(fr)) {
	        String cadena = br.readLine();
	        while (cadena != null) {
	            String[] cadenaPartida = cadena.split("/");
	            String nombreVideojuego = cadenaPartida[0];
	            int notaVideojuego = Integer.parseInt(cadenaPartida[1]);
	            String companiaVideojuego = cadenaPartida[2];
	            // Comparar sin distinguir mayúsculas y minúsculas
	            if (videojuego.equalsIgnoreCase(nombreVideojuego)) {
	                v = new Videojuego();
	                v.setNombre(nombreVideojuego);
	                v.setNota(notaVideojuego);
	                v.setCompania(companiaVideojuego);
	                return v;
	            }
	            cadena = br.readLine();
	        }
	        return null;
	    } catch (Exception e) {
	        throw e;
	    }
	}

	/**
	 * Método que dado un videojuego en el fichero "videojuegos.txt". Se añadirá a
	 * la ultima línea. Se persistirá en formato "NOMBRE/NOTA/COMPAÑIA"
	 * 
	 * @param v es el videojuego que queremos persistir
	 * @throws Exception en caso de que haya algún problema en el fichero de entrada
	 *                   salida
	 */
	public void register(Videojuego v, String nombreFichero) throws Exception {
	    File f = new File(nombreFichero);
	    if (!f.exists()) {
	        throw new Exception("El fichero no existe");
	    }
	    try (FileWriter fw = new FileWriter(f, true); BufferedWriter bw = new BufferedWriter(fw)) {
	        bw.write(v.getNombre() + "/" + v.getNota() + "/" + v.getCompania());
	        bw.newLine();
	    } catch (Exception e) {
	        throw e;
	    }
	}

	/**
	 * Metodo que muestra todos los videojuegos y sus datos persistentes en el fichero
	 * @return listaVideojuegos Devuelve un ArrayList con todos lo videojuegos
	 * @throws Exception En caso de error en algun fichero en la salida
	 */
	public ArrayList<Videojuego> listarVideojuego(String nombreFichero) throws Exception {
		ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

		try (FileReader fr = new FileReader(nombreFichero); BufferedReader br = new BufferedReader(fr)) {

			String cadena;
			while ((cadena = br.readLine()) != null) {
				String[] cadenaPartida = cadena.split("/");
				if (cadenaPartida.length < 3) {

					continue;
				}

				String nombreVideojuego = cadenaPartida[0];
				int notaVideojuego;

				try {
					notaVideojuego = Integer.parseInt(cadenaPartida[1]);
				} catch (NumberFormatException e) {
					continue;
				}

				String companiaVideojuego = cadenaPartida[2];

				Videojuego v = new Videojuego(nombreVideojuego, notaVideojuego, companiaVideojuego);
				listaVideojuegos.add(v);
			}

		} catch (Exception e) {
			throw e;
		}
		return listaVideojuegos;
	}

	/**
	 * Recorre el fichero y elimina la linea del fichero que coincida con ese videojuego
	 * @param nombreVideojuego Nombre del videojuego a eliminar
	 * @throws IOException Error 500
	 */
	public void eliminarVideojuego(String nombreVideojuego, String nombreFichero) throws IOException {
		List<String> lineas = new ArrayList<>();
		boolean encontrado = false;

		try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.startsWith(nombreVideojuego.toLowerCase() + "/")) {
					encontrado = true;
					continue;
				}
				lineas.add(linea);
			}
		}
		if (encontrado) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {
				for (String l : lineas) {
					writer.write(l);
					writer.newLine();
				}
			}
			System.out.println("Videojuego '" + nombreVideojuego + "' eliminado.");
		} else {
			System.out.println("Videojuego no encontrado: " + nombreVideojuego);
		}
	}
}
