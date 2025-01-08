package modelo.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.entidad.Usuario;

// Se encarga de guardar datos y ya, no realiza nada mas, solo compara y guarda

public class DaoUsuarioFichero {
	private static final String NOMBRE_FICHERO = "usuarios.dat";
	
	/**
	 * Metodo que dado un nombre pasado por parametro busca su coincidencia
	 * en el fichero "usuarios.dat" y en caso de que lo encuentre lo devuelve
	 * junto con su password
	 * @param nombre a buscar en el fichero
	 * @return Usuario, en caso de que este en el fichero, null en caso contrario
	 * @throws Exception, en caso de que haya algún problema en el fichero de 
	 * entrada salida
	 */
	public Usuario getByName(String nombre) throws Exception {
		Usuario usuario = null;
		try(FileReader fr = new FileReader(NOMBRE_FICHERO);
				BufferedReader br = new BufferedReader(fr)){
			String cadena = br.readLine(); // -> Siempre devuelve las cosas USUARIO/PASSWORD
			while(cadena != null) {
				String[] cadenaPartida = cadena.split("/");
				String nombreUsuario = cadenaPartida[0];
				String passwordUsuario = cadenaPartida[1];
				if(nombre.equals(nombreUsuario)) {
					usuario = new Usuario();
					usuario.setNombre(nombreUsuario);
					usuario.setPassword(passwordUsuario);
					return usuario;
				}
				cadena = br.readLine();
			}
			return null;
			
		} catch (IOException e) {
			throw e;
		}
	}
	/**
	 * Metodo que dado un usuario lo persista en el fichero "usuarios.dat". Se añadira
	 * a la ultima linea. Se persistira en formato "USUARIO/Password"
	 * @param u es el usuario que queremos persistir
	 * @return true en caso de que el usuario se haya persistido, false en caso contrario
	 * @throws Exception, en caso de que haya algún problema en el fichero de 
	 * entrada salida
	 */
	public void register(Usuario u) throws Exception {
		try(FileWriter fw = new FileWriter(NOMBRE_FICHERO, true);
				BufferedWriter bw = new BufferedWriter(fw)){
			bw.write(u.toString());
			
		} catch (IOException e) {
			throw e;
		}
		
	}
	

}
