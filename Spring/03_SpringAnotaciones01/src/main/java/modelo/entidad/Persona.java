package modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Importante, para poder trabajar con objetos en Sprring, tienen que llevar
// la notación JavaBean.

@Component("personaBean")
/*
 * La anotaciones "@Component" da de alta un objeto en el contexto de Spring 
 * de la clase donde se encuentre (en este caso Persona),y como id utilizara
 * el nombre de la clase usando lowerCamelCase(persona)
 * 
 * Esto es lo que haría por defecto, solo con poner "@Component".
 * <bean id="persona" class="modelo.entidad.Persona" scope="singleton">
 * 
 * Si queremos cambiar el "scope" del bean lo haremos con la
 * anotacion "@scope("prototype")
 * 
 * Si queremos cambiar el id del "bean" lo podemos poner despues del "@Component"
 * 
 * Ahora esto seria equivalente a:
 * <bean id="persona" class="modelo.entidad.Persona" scope="prototype">
 * 
 * Las anotaciones en Java suelen servir para añadir funcionalidades a las clases
 * de manera automatica.
 */
@Scope("prototype")
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
