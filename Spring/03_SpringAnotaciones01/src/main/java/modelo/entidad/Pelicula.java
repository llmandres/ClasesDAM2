package modelo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pelicula {
	private String titulo;
	@Autowired
	private Director director;
	@Autowired
	// "@Qualifier nos sirve para inyectar un bean en especifico pasandole la id
	@Qualifier("personaBean")
	private Persona productor;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public Persona getProductor() {
		return productor;
	}
	public void setProductor(Persona productor) {
		this.productor = productor;
	}
	
	
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", director=" + director + ", productor=" + productor + "]";
	}
	
	
	


	
	
	

}
