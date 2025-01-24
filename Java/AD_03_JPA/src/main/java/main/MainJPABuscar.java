package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Coche;

public class MainJPABuscar {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		System.out.println("Entity Manager Creado");
		
		Coche coche = new Coche();

		

		coche = em.find(Coche.class, 1); // Buscar por ID
		
		System.out.println(coche);
		// Cerramos

		em.close();
	}

}
