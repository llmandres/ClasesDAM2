package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.entidad.Usuario;
import modelo.negocio.GestorUsuario;
import modelo.persistencia.DaoUsuarioFichero;

class GestorUsuarioTest {
	   private GestorUsuario gestorUsuario;
	   private DaoUsuarioFichero df;
	    private static final String TEST_FILE = "test_usuarios.txt"; 

	    @BeforeEach
	    public void setUp() throws IOException {
	        gestorUsuario = new GestorUsuario();
	        File file = new File(TEST_FILE);
	        if (!file.exists()) {
	            file.createNewFile();
	        }


	        FileWriter writer = new FileWriter(TEST_FILE);
	        writer.close();
	    }

	    @AfterEach
	    public void eliminarArchivoPrueba() {
	        File file = new File(TEST_FILE);
	        if (file.exists()) {
	            file.delete();
	        }
	    }

	    @Test
	    public void testValidarUsuarioExistenteYValido() throws Exception {
	        Usuario usuario = new Usuario();
	        usuario.setNombre("juan");
	        usuario.setPassword("1234");
	        registrarUsuario(usuario); 

	        int resultado = gestorUsuario.validar(usuario);
	        assertEquals(1, resultado); 
	    }

	    @Test
	    public void testValidarUsuarioExistentePeroInvalido() throws Exception {
	        Usuario usuario = new Usuario();
	        usuario.setNombre("juan");
	        usuario.setPassword("1234");
	        registrarUsuario(usuario); 

	        Usuario usuarioInvalido = new Usuario();
	        usuarioInvalido.setNombre("juan");
	        usuarioInvalido.setPassword("wdwd");

	        int resultado = gestorUsuario.validar(usuarioInvalido);
	        assertEquals(2, resultado); 
	    }

	    @Test
	    public void testValidarUsuarioNoExistente() throws Exception {
	        Usuario usuarioNoExistente = new Usuario();
	        usuarioNoExistente.setNombre("pedro");
	        usuarioNoExistente.setPassword("1234");

	        int resultado = gestorUsuario.validar(usuarioNoExistente);
	        assertEquals(0, resultado); 
	    }

	    @Test
	    public void testGuardarUsuarioValido() throws Exception {

	        Usuario nuevoUsuario = new Usuario();
	        nuevoUsuario.setNombre("maria");
	        nuevoUsuario.setPassword("5678");


	        int resultado = gestorUsuario.guardar(nuevoUsuario);
	        assertEquals(3, resultado); 

	        int validacion = gestorUsuario.validar(nuevoUsuario);
	        assertEquals(1, validacion); 
	    }

	    @Test
	    public void testGuardarUsuarioNull() {
	        int resultado = gestorUsuario.guardar(null);
	        assertEquals(0, resultado); 
	    }

	    @Test
	    public void testGuardarNombreVacio() {
	        Usuario usuarioVacioNombre = new Usuario();
	        usuarioVacioNombre.setNombre(" ");
	        usuarioVacioNombre.setPassword("1234");


	        int resultado = gestorUsuario.guardar(usuarioVacioNombre);
	        assertEquals(1, resultado); 
	    }

	    @Test
	    public void testGuardarPasswordVacio() {

	        Usuario usuarioVacioPassword = new Usuario();
	        usuarioVacioPassword.setNombre("maria");
	        usuarioVacioPassword.setPassword(" ");


	        int resultado = gestorUsuario.guardar(usuarioVacioPassword);
	        assertEquals(2, resultado); 
	    }

	    public void testGuardarExcepcionEnFichero() {
	        Usuario usuarioExistente = new Usuario();
	        usuarioExistente.setNombre("juan");
	        usuarioExistente.setPassword("1234");

	        try {

	            registrarConExcepcion(usuarioExistente);
	            
	            fail("IOException.");
	            
	        } catch (IOException e) {

	            assertEquals("Error ", e.getMessage()); 
	        }
	    }


	    private void registrarUsuario(Usuario usuario) throws Exception {
	        DaoUsuarioFichero daoUsuarioFichero = new DaoUsuarioFichero();
	        daoUsuarioFichero.registrar(usuario);
	    }
	    public void registrarConExcepcion(Usuario usuario) throws IOException {
	        throw new IOException("Error al guardar el usuario");
	    }
	}

