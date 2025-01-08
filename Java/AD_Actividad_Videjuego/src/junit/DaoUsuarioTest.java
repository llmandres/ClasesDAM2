package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.entidad.Usuario;
import modelo.persistencia.DaoUsuarioFichero;

	public class DaoUsuarioTest {

	    private DaoUsuarioFichero daoUsuarioFichero;

	    @BeforeEach
	    public void setUp() {
	        daoUsuarioFichero = new DaoUsuarioFichero();

	        prepararFicheroDePrueba(); // Fichero de prueba
	    }

	    @Test
	    public void testGetByNameUsuarioExistente() throws Exception {
	
	        Usuario usuario = daoUsuarioFichero.getByName("juan");
	        assertNotNull(usuario);
	        assertEquals("juan", usuario.getNombre());
	        assertEquals("1234", usuario.getPassword());
	    }

	    @Test
	    public void testGetByNameUsuarioNoExistente() throws Exception {

	        Usuario usuario = daoUsuarioFichero.getByName("inexistente");
	        assertNull(usuario);
	    }

	    @Test
	    public void testRegistrarUsuarioNuevo() throws Exception {
	
	        Usuario nuevoUsuario = new Usuario();
	        nuevoUsuario.setNombre("ana");
	        nuevoUsuario.setPassword("abcd");

	        daoUsuarioFichero.registrar(nuevoUsuario);


	        Usuario usuarioRegistrado = daoUsuarioFichero.getByName("ana");
	        assertNotNull(usuarioRegistrado);
	        assertEquals("ana", usuarioRegistrado.getNombre());
	        assertEquals("abcd", usuarioRegistrado.getPassword());
	    }
	    public void prepararFicheroDePrueba() {
	        File archivo = new File("usuarios_test.txt");
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
	        	// Usuarios de prueba random
	            bw.write("juan/1234");
	            bw.newLine();
	            bw.write("maria/5678");
	            bw.newLine();
	        } catch (IOException e) {
	            fail("Error");
	        }
	    }
	    @AfterEach
	    public void limpiarFicheroDePrueba() {
	        File archivo = new File("usuarios_test.txt");
	        if (archivo.exists()) {
	            archivo.delete();
	        }
	    }
	}

