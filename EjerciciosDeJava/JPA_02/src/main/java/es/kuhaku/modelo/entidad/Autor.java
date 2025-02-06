package es.kuhaku.modelo.entidad;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Component
@Data
@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Libro> listaLibros;
	

}
