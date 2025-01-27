package main.persona;


import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Coche;
import modelo.entidad.Persona;

public class MainJPAInsertar {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		System.out.println("Entity Manager Creado");
		
		Persona p = new Persona();
		p.setNombre("Vegeta");
		p.setFechaNacimiento(new Date());
		p.setCasado(true);
		
		EntityTransaction tx =  em.getTransaction();
		
		tx.begin();
		em.persist(p);
		em.persist(p);
		em.persist(p);
		// No importa cuantas veces usemos persist( proque
		// siempre será el mismo objeto). Si queremos
		// dar de alta otro objeto, tendremos
		// que crearlo
		p = new Persona();
		p.setNombre("Goku");
		p.setFechaNacimiento(new Date());
		p.setCasado(true);
		// Ahora que la referencia esta apuntando a otro objeto, no lo contara con el mismoo, por lo tanto se insertaran ambos.
		
		p = new Persona();
		p.setNombre("Bulma");
		em.merge(p); // COn esto tambien se puede dar de alta. Merge devuelve la referencia con la que ha creado el objeto
	// Aqui no se cambia nada porque el Objeto Bumla es diferente al objeto nulma	
		p.setNombre("MRsTATAN");
		
		Persona p2 = em.merge(p); // devuelve la referencia del objeto
		p2.setNombre("Mutenroshi");
		
		em.clear();
		
		
		// Cerramos
		tx.commit();
		em.close();
	}

}
