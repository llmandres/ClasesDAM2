package modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "coches")
public class Coche {
	// Ponemos @ID encima del atributo que sera primary key
	@Id
	private int id;
	private String marca;
	private String modelo;
	private long km;

}
