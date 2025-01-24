package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Coche;

public class MainJPABorrar {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		System.out.println("Entity Manager Creado");
		
		Coche coche = new Coche();

		
		EntityTransaction tx =  em.getTransaction();
		
		tx.begin();
		coche = em.find(Coche.class, 1);
		em.remove(coche);
		coche = em.find(Coche.class, 1);
		System.out.println(coche);
		
		// Cerramos
		tx.commit();
		//Si se cierra, automaticamente hace commit
		em.close();
	}

}
