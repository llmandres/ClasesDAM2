package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.entidad.Videojuego;
import modelo.negocio.GestorVideojuego;
import modelo.persistencia.DaoVideojuegoFichero;

class GestorVideojuegoTest {
	  private GestorVideojuego gestorVideojuego;
	    private DaoVideojuegoFichero daoVideojuegoFichero;

	    @BeforeEach
	    public void setUp() {
	        daoVideojuegoFichero = new DaoVideojuegoFichero();
	        gestorVideojuego = new GestorVideojuego();

	        prepararFicheroDePrueba();
	    }

	    @Test
	    public void testValidarVideojuegoExistente() {
	        Videojuego videojuego = new Videojuego("halo", 9, "Bungie");
	        int resultado = gestorVideojuego.validarVideojuego(videojuego, "videojuegos_test.txt");
	        assertEquals(1, resultado); 
	    }

	    @Test
	    public void testValidarVideojuegoNoExistente() {
	        Videojuego videojuego = new Videojuego("inexistente", 0, "Desconocido");
	        int resultado = gestorVideojuego.validarVideojuego(videojuego, "videojuegos_test.txt");
	        assertEquals(0, resultado); 
	    }

	    @Test
	    public void testGuardarVideojuegoValido() {
	        Videojuego nuevoVideojuego = new Videojuego("zelda", 10, "Nintendo");
	        int resultado = gestorVideojuego.guardar(nuevoVideojuego, "videojuegos_test.txt");
	        assertEquals(3, resultado); 

	        Videojuego videojuegoGuardado = null;
	        

	            try {
					videojuegoGuardado = daoVideojuegoFichero.getByName("zelda", "videojuegos_test.txt");
				} catch (Exception e) {
					e.printStackTrace();
				}


	        assertNotNull(videojuegoGuardado);
	        assertEquals("zelda", videojuegoGuardado.getNombre());
	        assertEquals(10, videojuegoGuardado.getNota());
	        assertEquals("Nintendo", videojuegoGuardado.getCompania());
	    }

	    @Test
	    public void testGuardarVideojuegoNombreVacio() {
	        Videojuego videojuego = new Videojuego("", 10, "Nintendo");
	        int resultado = gestorVideojuego.guardar(videojuego, "videojuegos_test.txt");
	        assertEquals(1, resultado); 
	    }

	    @Test
	    public void testListarVideojuegos() {
	        ArrayList<Videojuego> lista;
	        try {
	            lista = gestorVideojuego.listarVideojuego("videojuegos_test.txt");
	        } catch (Exception e) {
	            fail("Error");
	            return; 
	        }

	        assertEquals(2, lista.size()); 

	        Videojuego primero = lista.get(0);
	        assertEquals("halo", primero.getNombre());
	        assertEquals(9, primero.getNota());
	        assertEquals("Bungie", primero.getCompania());

	        Videojuego segundo = lista.get(1);
	        assertEquals("fortnite", segundo.getNombre());
	        assertEquals(7, segundo.getNota());
	        assertEquals("Epic Games", segundo.getCompania());
	    }

	    @Test
	    public void testEliminarVideojuegoExistente() {
	        gestorVideojuego.eliminarVideojuego("halo", "videojuegos_test.txt");

	        Videojuego videojuego;
	        try {
	            videojuego = daoVideojuegoFichero.getByName("halo", "videojuegos_test.txt");
	        } catch (Exception e) {
	            fail("Error");
	            return; 
	        }

	        assertNull(videojuego);

	
	        ArrayList<Videojuego> lista;
	        try {
	            lista = daoVideojuegoFichero.listarVideojuego("videojuegos_test.txt");
	        } catch (Exception e) {
	            fail("Error al listar los videojuegos después de eliminar: " + e.getMessage());
	            return; 
	        }

	        assertEquals(1, lista.size());
	        assertEquals("fortnite", lista.get(0).getNombre());
	    }

	    @Test
	    public void testEliminarVideojuegoNoExistente() {
	        gestorVideojuego.eliminarVideojuego("inexistente", "videojuegos_test.txt");

	        ArrayList<Videojuego> lista;
	        try {
	            lista = daoVideojuegoFichero.listarVideojuego("videojuegos_test.txt");
	        } catch (Exception e) {
	            fail("Error al listar los videojuegos después de eliminar: " + e.getMessage());
	            return;
	        }

	        assertEquals(2, lista.size()); 
	    }

	    public void prepararFicheroDePrueba() {
	        File file = new File("videojuegos_test.txt");
	        if (!file.exists()) {
	            try {
	                file.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
	            // ficheros de prueba
	            bw.write("halo/9/Bungie");
	            bw.newLine();
	            bw.write("fortnite/7/Epic Games");
	            bw.newLine();
	        } catch (IOException e) {
	            fail("Error al preparar el fichero de prueba: " + e.getMessage());
	        }
	    }

	    @AfterEach
	    public void limpiarFicheroDePrueba() {
	        File archivo = new File("videojuegos_test.txt");
	        if (archivo.exists()) {
	            archivo.delete();
	        }
	    }
}


