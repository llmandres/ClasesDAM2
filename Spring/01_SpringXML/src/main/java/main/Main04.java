package main;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Persona;

public class Main04 {
	
	public static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context04.xml");
		
		@SuppressWarnings("unchecked")
		List<String> listaNombres = context.getBean("ListaNombres", List.class);
		
		listaNombres.forEach(v -> System.out.println(v));
		@SuppressWarnings("unchecked")
		List<Persona> listaPersonas = context.getBean("ListaPersonas", List.class);
		
		listaPersonas.forEach(v -> System.out.println(v));
		@SuppressWarnings("unchecked") // Esto sirve para quitar los warnings que no podemos controlar o hacer algo al respecto
		Map<Integer, Persona> mapaPersonas = context.getBean("MapaPersonas", Map.class);
		
		mapaPersonas.forEach((v,k) -> {
			System.out.println("Clave : " + k + " Valor : " + v);
					});
	}

}