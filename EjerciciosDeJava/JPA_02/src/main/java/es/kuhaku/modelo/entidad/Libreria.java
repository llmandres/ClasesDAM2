package es.kuhaku.modelo.entidad;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Data;

@Component
@Data
@Entity
public class Libreria {
	private String id;
	private String nombre;
	private String nombreDuenio;
	private String direccion;
	private List<Libro> coleccionLibros;

}
