package modelo.entidad;

// Importante, para poder trabajar con objetos en Sprring, tienen que llevar
// la notación JavaBean.
public class Persona {
	private String nombre;
	private int Edad;
	private double peso;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", Edad=" + Edad + ", peso=" + peso + "]";
	}
	
	
	

}
