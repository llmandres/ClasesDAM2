package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuracion.ConfiguracionSpring;
import modelo.entidad.Pelicula;

//En este ejemplo vamos a dar de alta el contexto de Spring mediante una clase
// en vez de mediante un XML

public class MainAnotaciones02 {
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		
		Pelicula p = context.getBean("pelicula", Pelicula.class);
		System.out.println(p);
		
	}

}
