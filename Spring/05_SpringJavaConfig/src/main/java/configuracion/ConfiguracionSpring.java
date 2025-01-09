package configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;

@Configuration
public class ConfiguracionSpring {
	
	// El Tipo del metodo es la clase del bean y la ID sera el nombre del metodo
	@Bean
	@Scope("prototype")
	public Director director() {
		return new Director();
	}
	
	// Cuando le metemos un parametro es como usar ref (autowired). Esto sería un Autowired
	@Bean
	@Scope("prototype")
	public Pelicula pelicula1(Director director) {
		Pelicula p = new Pelicula();
		p.setDirector(director);
		p.setGenero("Sci-Fi");
		return p;
	}
	

}
