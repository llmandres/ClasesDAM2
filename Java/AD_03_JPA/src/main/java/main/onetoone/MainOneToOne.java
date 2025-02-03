package main.onetoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Cliente;
import modelo.entidad.CuentaBancaria;

public class MainOneToOne {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		CuentaBancaria cb = new CuentaBancaria();
		cb.setNumeroCuenta("167898F");
		cb.setEntidad("Caixa");
		
		Cliente c = new Cliente();
		c.setNombre("Bart Simpson");
		c.setTelefono("98123424");
		c.setCuentaBancaria(cb);
		
		// Es necesario persistir los 2 a pesar de que esten unidas
		em.persist(c);
		// Como hemos hecho cascade ALL en Cliente, ya no hace falta persistir la cuenta Bancaria tambien.
		//em.persist(cb);
		tx.commit();
		
		Cliente c2 = em.find(Cliente.class, 2);
		System.out.println(c2);

	}

}
