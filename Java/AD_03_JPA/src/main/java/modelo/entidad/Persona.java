package modelo.entidad;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="personas")
@Data
public class Persona {
	@Id
	// Autoincremental
	// Por Tablas
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncremental
	private Integer id;
	@Column (name = "nombre_persona", length = 255) // Esto sería el nombre del atributo y su VARCHAR
	private String nombre;
	@Column (name = "fecha_nacimiento")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	@Transient
	private boolean casado;

}
