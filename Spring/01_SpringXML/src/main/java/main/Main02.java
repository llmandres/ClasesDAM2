package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Persona;

public class Main02 {
	
	public static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context02.xml");
		
		// Lo que hace el prototype es dar un objeto igual al que esta en el context, pero en el objeto como tal.
		// Una vez te da este objeto ya no se reponsabiliza de el.
		Persona p = context.getBean("personaPrototipada", Persona.class);
		p.setNombre("Juan");
		System.out.println(p);
		
		// Al ser prototipado el objeto de aqui abajo no sera igual al anterior, si no que tendra los mismos valores
		// que el que se encuentra en el contexto de Spring. Es decir, las prototipadas solo te va a dar copias.
		p = context.getBean("personaPrototipada", Persona.class);
		System.out.println(p);
		
		
	}

}
