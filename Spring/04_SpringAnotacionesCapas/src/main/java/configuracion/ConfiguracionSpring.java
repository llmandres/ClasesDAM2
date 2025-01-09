package configuracion;

import org.springframework.context.annotation.ComponentScan;

// JAVACONFIG, unicamente tienes que hacer lo mismo que se realiza con Anotaciones,
// pero en vez de crear un XML, se crea un @ComponentScan para usar una clase.

// Esto aplica igual que en el xml, es decir, busca anotaciones Spring 
// en los paquetes que le digamos.
@ComponentScan(basePackages = "modelo")
public class ConfiguracionSpring {
	

}
