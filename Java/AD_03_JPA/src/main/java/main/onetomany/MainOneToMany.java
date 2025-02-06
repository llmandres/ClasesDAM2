package main.onetomany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Cliente;
import modelo.entidad.CuentaBancaria;
import modelo.entidad.Tareas;

public class MainOneToMany {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Tareas t1 = new Tareas();
		t1.setImportancia("Mucha");
		t1.setContenido("Ir al bar");
		
		Tareas t2 = new Tareas();
		t2.setImportancia("Poca");
		t2.setContenido("Estudiar AD");
		
		List<Tareas> listaTareas = new ArrayList<Tareas>();
		listaTareas.add(t2);
		listaTareas.add(t1);
		
		Cliente c1 = new Cliente();
		c1.setNombre("Ranma");
		c1.setTelefono("637284593");
		c1.setListaTareas(listaTareas);

		em.persist(c1);
		
		tx.commit();
		
		em.close();
		

	}

}
