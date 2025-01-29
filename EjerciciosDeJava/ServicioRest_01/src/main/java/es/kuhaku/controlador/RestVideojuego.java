package es.kuhaku.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.kuhaku.entidad.Videojuego;
import es.kuhaku.modelo.GestorVideojuego;

import java.util.List;

@RestController
@RequestMapping("/videojuegos")
public class RestVideojuego {

    @Autowired
    private GestorVideojuego gv;
    
    // Agregar Juego /videojuego en POST y pones en el body el objeto en JSON
        @PostMapping
        public ResponseEntity<String> agregarVideojuego(@RequestBody Videojuego nuevoVideojuego) {
            boolean agregado = gv.agregarVideojuego(nuevoVideojuego);
            if (agregado) {
                return ResponseEntity.status(201).body("Videojuego agregado con éxito");
            } else {
                return ResponseEntity.status(400).body("Error al agregar el videojuego");
            }
        }

        // GET /videojuegos  Muestra todo
        @GetMapping
        public List<Videojuego> listarVideojuegos() {
            return gv.listarTodosLosVideojuegos();
        }

        
        //GET /videojuegos/2 Y muestra el juego con el id 2
        @GetMapping("/{id}")
        public ResponseEntity<Videojuego> obtenerVideojuego(@PathVariable int id) {
            Videojuego videojuego = gv.obtenerVideojuegoPorId(id);
            if (videojuego != null) {
                return ResponseEntity.ok(videojuego);
            } else {
                return ResponseEntity.status(404).body(null); 
            }
        }

      //GET /videojuegos/2 Y modifica el juego con el id 2 con el que este en el body
        @PutMapping("/{id}")
        public ResponseEntity<String> modificarVideojuego(@PathVariable int id, @RequestBody Videojuego videojuegoActualizado) {
            boolean actualizado = gv.modificarVideojuegoPorId(id, videojuegoActualizado);
            if (actualizado) {
                return ResponseEntity.ok("Videojuego modificado con éxito");
            } else {
                return ResponseEntity.status(404).body("Videojuego no encontrado");
            }
        }

        // GET /videojuegos/2 Y borra el juego con el id 2
        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminarVideojuego(@PathVariable int id) {
            boolean eliminado = gv.eliminarVideojuegoPorId(id);
            if (eliminado) {
                return ResponseEntity.ok("Videojuego eliminado con éxito");
            } else {
                return ResponseEntity.status(404).body("Videojuego no encontrado");
            }
        }

      //GET /videojuegos/buscar/nombreJuego Y muestra el juego con el nombre dado
        @GetMapping("/buscar/{nombre}")
        public List<Videojuego> listarVideojuegosPorNombre(@PathVariable String nombre) {
            return gv.listarVideojuegosPorNombre(nombre);
        }


    }


    
