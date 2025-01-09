package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Ordenador;

public class Main01 {
	
	public static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("context01.xml");
		
		Ordenador o1 = context.getBean("Ordenador", Ordenador.class);
		System.out.println(o1);

	}

}
