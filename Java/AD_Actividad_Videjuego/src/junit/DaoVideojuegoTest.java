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
import modelo.persistencia.DaoVideojuegoFichero;

public class DaoVideojuegoTest {
	
	
	private DaoVideojuegoFichero daoVideojuegoFichero;

    @BeforeEach
    public void setUp() {
        daoVideojuegoFichero = new DaoVideojuegoFichero();
        prepararFicheroDePrueba(); 
    }

    @Test
    public void testRegisterNuevoVideojuego() throws Exception {
        Videojuego nuevoVideojuego = new Videojuego();
        nuevoVideojuego.setNombre("zelda");
        nuevoVideojuego.setNota(10);
        nuevoVideojuego.setCompania("Nintendo");

        daoVideojuegoFichero.register(nuevoVideojuego, "videojuegos_test.txt");

 
        Videojuego videojuegoRegistrado = daoVideojuegoFichero.getByName("zelda", "videojuegos_test.txt");
        assertNotNull(videojuegoRegistrado);
        assertEquals("zelda", videojuegoRegistrado.getNombre());
        assertEquals(10, videojuegoRegistrado.getNota());
        assertEquals("Nintendo", videojuegoRegistrado.getCompania());
    }

    @Test
    public void testGetByNameVideojuegoExistente() throws Exception {
        Videojuego v = daoVideojuegoFichero.getByName("halo", "videojuegos_test.txt");
        assertNotNull(v);
        assertEquals("halo", v.getNombre());
        assertEquals(9, v.getNota());
        assertEquals("Bungie", v.getCompania());
    }

    @Test
    public void testGetByNameVideojuegoNoExistente() throws Exception {
        Videojuego v = daoVideojuegoFichero.getByName("inexistente", "videojuegos_test.txt");
        assertNull(v);
    }

    @Test
    public void testListarVideojuegos() throws Exception {
        ArrayList<Videojuego> lista = daoVideojuegoFichero.listarVideojuego("videojuegos_test.txt");
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
    public void testEliminarVideojuegoExistente() throws Exception {
        daoVideojuegoFichero.eliminarVideojuego("halo", "videojuegos_test.txt");

        Videojuego v = daoVideojuegoFichero.getByName("halo", "videojuegos_test.txt");
        assertNull(v);

        ArrayList<Videojuego> lista = daoVideojuegoFichero.listarVideojuego("videojuegos_test.txt");
        assertEquals(1, lista.size());
        assertEquals("fortnite", lista.get(0).getNombre());
    }

    @Test
    public void testEliminarVideojuegoNoExistente() throws Exception {
        daoVideojuegoFichero.eliminarVideojuego("inexistente", "videojuegos_test.txt");

        ArrayList<Videojuego> lista = daoVideojuegoFichero.listarVideojuego("videojuegos_test.txt");
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

            bw.write("halo/9/Bungie");
            bw.newLine();
            bw.write("fortnite/7/Epic Games");
            bw.newLine();
        } catch (IOException e) {
            fail("Error al preparar el fichero de prueba: " + e.getMessage());
        }
    }

    @AfterEach
    public void limpiarFichero() {
        File archivo = new File("videojuegos_test.txt");
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}