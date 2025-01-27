package main.persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Coche;
import modelo.entidad.Persona;

public class MainJPABuscar {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		System.out.println("Entity Manager Creado");
		
		Persona p = new Persona();

		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.find(Persona.class, 1); // Buscar por ID
		em.clear();
		p = em.find(Persona.class, 1);
		p = em.find(Persona.class, 1);
		em.clear();
		//em.remove(o);
		p = em.merge(p); // Para borrar un objeto de JPA debe estar en el contexto, esto se puede hacer con merge
		 // O buscandolo como visto en el ejemplo de Coche
		em.remove(p);
		tx.commit();
		
		System.out.println(p);
		// Cerramos

		em.close();
	}

}
