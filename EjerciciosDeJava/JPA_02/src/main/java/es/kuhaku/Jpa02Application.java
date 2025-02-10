package es.kuhaku;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.mapping.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.kuhaku.modelo.entidad.Autor;
import es.kuhaku.modelo.entidad.Editorial;
import es.kuhaku.modelo.entidad.Libreria;
import es.kuhaku.modelo.entidad.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class Jpa02Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Jpa02Application.class, args);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");


		        // Crear autores
		        Autor au1 = new Autor();
		        au1.setId(1);
		        au1.setNombre("Gabriel");
		        au1.setApellidos("García Márquez");
		        au1.setFechaNacimiento("1927-03-06"); // 6 de marzo de 1927

		        Autor au2 = new Autor();
		        au2.setId(2);
		        au2.setNombre("Isabel");
		        au2.setApellidos("Allende");
		        au2.setFechaNacimiento("1942-08-02"); // 2 de agosto de 1942

		        Autor au3 = new Autor();
		        au3.setId(3);
		        au3.setNombre("Julio");
		        au3.setApellidos("Cortázar");
		        au3.setFechaNacimiento("1914-08-26"); // 26 de agosto de 1914

		        // Crear editoriales
		        Editorial e1 = new Editorial();
		        e1.setId(1);
		        e1.setNombre("Editorial Sudamericana");
		        e1.setDireccion("Buenos Aires, Argentina");

		        Editorial e2 = new Editorial();
		        e2.setId(2);
		        e2.setNombre("Alfaguara");
		        e2.setDireccion("Madrid, España");

			    Libro l1 = new Libro(1, "Cien años de soledad", 50.0, e1, au1);
		        Libro l2 = new Libro(2, "El amor en los tiempos del cólera", 45.0, e2, au1);
		        Libro l3 = new Libro(3, "La casa de los espíritus", 40.0, e2, au2);
		        Libro l4 = new Libro(4, "Paula", 35.0, e1, au2);
		        Libro l5 = new Libro(5, "Rayuela", 55.0, e1, au3);
		        Libro l6 = new Libro(6, "Bestiario", 30.0, e2, au3);
		        Libro l7 = new Libro(7, "Crónica de una muerte anunciada", 25.0, e1, au1);
		        Libro l8 = new Libro(8, "De amor y de sombra", 30.0, e2, au2);

	
		        e1.setListaLibros(new ArrayList<Libro>()); 
		        e1.getListaLibros().add(l1);
		        e1.getListaLibros().add(l4);
	

		        e2.setListaLibros(new ArrayList<Libro>()); 
		        e2.getListaLibros().add(l2);
		        e2.getListaLibros().add(l3);
	

		        au1.setListaLibros(new ArrayList<Libro>());
		        au1.getListaLibros().add(l1);
		        au1.getListaLibros().add(l2);


		        au2.setListaLibros(new ArrayList<Libro>()); 
		        au2.getListaLibros().add(l3);
		        au2.getListaLibros().add(l4);
		 

		        au3.setListaLibros(new ArrayList<Libro>());
		        au3.getListaLibros().add(l5);
	

		        Libreria lb1 = new Libreria();
		        lb1.setId(1);
		        lb1.setNombre("Librería Central");
		        lb1.setNombre("María López");
		        lb1.setDireccion("Calle Mayor, 45, Madrid");
		        lb1.setListaLibros(new ArrayList<>());
		        lb1.getListaLibros().add(l1);
		        

		        Libreria lb2 = new Libreria();
		        lb2.setId(2);
		        lb2.setNombre("Librería del Sur");
		        lb2.setNombre("Carlos Pérez");
		        lb2.setDireccion("Av. de los Pinos, 123, Sevilla");
		        lb2.setListaLibros(new ArrayList<>());
		        lb2.getListaLibros().add(l2);
		        
		        EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				
				//Como estan puestos los cascades, al dar de alta un cliente, se dan de alta
				//sus comerciales, y a dar de alta esos comerciales, se dan de alta los clientes
				//Si no hubiera cascades, habr�a que hacerlo poco a poco como en las relaciones
				//"one to many"
				em.persist(l1);
				
				//Ojo, JPA lanza los insertes NO NECESARIAMENTE en el mismo orden que se crean los
				//objetos de este ejemplo, por lo que los IDs de los clientes pueden variar
				//en la BBDD
				em.getTransaction().commit();
				em.close();
				emf.close();		
		        
		    }
		}

		
		
		
