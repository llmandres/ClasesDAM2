package es.kuhaku;

import java.util.ArrayList;

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
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        Autor au1 = new Autor();
        au1.setNombre("Gabriel");
        au1.setApellidos("García Márquez");
        au1.setFechaNacimiento("1927-03-06");

        Autor au2 = new Autor();
        au2.setNombre("Isabel");
        au2.setApellidos("Allende");
        au2.setFechaNacimiento("1942-08-02");

        Autor au3 = new Autor();
        au3.setNombre("Julio");
        au3.setApellidos("Cortázar");
        au3.setFechaNacimiento("1914-08-26");




        Editorial e1 = new Editorial();
        e1.setNombre("Editorial Sudamericana");
        e1.setDireccion("Buenos Aires, Argentina");

        Editorial e2 = new Editorial();
        e2.setNombre("Alfaguara");
        e2.setDireccion("Madrid, España");

        em.persist(e1);
        em.persist(e2);


        Libro l1 = new Libro("Cien años de soledad", 50.0, e1, au1);
        Libro l2 = new Libro("El amor en los tiempos del cólera", 45.0, e1, au1);
        Libro l3 = new Libro("La casa de los espíritus", 40.0, e2, au2);
        Libro l4 = new Libro("Paula", 35.0, e1, au2);
        Libro l5 = new Libro("Rayuela", 55.0, e1, au3);
        Libro l6 = new Libro("Bestiario", 30.0, e2, au3);
        Libro l7 = new Libro("Crónica de una muerte anunciada", 25.0, e1, au1);
        Libro l8 = new Libro("De amor y de sombra", 30.0, e2, au2);


        Libreria lb1 = new Libreria();
        lb1.setNombre("Librería Central");
        lb1.setNombreDueno("María López");
        lb1.setDireccion("Calle Mayor, 45, Madrid");
        lb1.setListaLibros(new ArrayList<>());
        lb1.getListaLibros().add(l1);
        lb1.getListaLibros().add(l2);
        lb1.getListaLibros().add(l3);
        lb1.getListaLibros().add(l4);

        Libreria lb2 = new Libreria();
        lb2.setNombre("Librería del Sur");
        lb2.setNombreDueno("Carlos Pérez");
        lb2.setDireccion("Av. de los Pinos, 123, Sevilla");
        lb2.setListaLibros(new ArrayList<>());
        lb2.getListaLibros().add(l5);
        lb2.getListaLibros().add(l6);
        lb2.getListaLibros().add(l7);
        lb2.getListaLibros().add(l8);

        em.persist(lb1);
        em.persist(lb2);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
