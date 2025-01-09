package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuracion.ConfiguracionSpring;
import modelo.entidades.Pelicula;

public class MainJavaConfig01 {

	private static ApplicationContext context;
	
	public static void main(String[] args) {		
		context = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		
		Pelicula p = context.getBean("pelicula1" , Pelicula.class);
		System.out.println(p);

	}

}
