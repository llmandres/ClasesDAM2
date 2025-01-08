package modelo.entidad;

public class Pelicula {
	private String pelicula;
	private Director director;
	
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	
	
	@Override
	public String toString() {
		return "Pelicula [pelicula=" + pelicula + ", director=" + director + "]";
	}
	
	
	

}
