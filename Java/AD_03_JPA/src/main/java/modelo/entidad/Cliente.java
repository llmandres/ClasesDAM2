package modelo.entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String telefono;
	
	
	// Donde pongais la anotacion ONE TO ONE estará la foreing key
	// ONE TO ONE, con cascade para que se referencie al objeto cliente en el Entity managera automaticamente
	
	// El fetch cambia que trae de la base de datos, si todas las relaciones o no
	@OneToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
	private CuentaBancaria cuentaBancaria;

}
