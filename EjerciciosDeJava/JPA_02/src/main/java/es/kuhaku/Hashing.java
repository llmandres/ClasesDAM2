package es.kuhaku;

import java.awt.Menu;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import es.kuhaku.modelo.entidad.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Hashing {

	public static void main(String[] args) {
	 	Scanner sc = new Scanner(System.in);
	 	Scanner scString = new Scanner(System.in);
	 	int opcion;
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
	        EntityManager em = emf.createEntityManager();
	        
	        do{
	        	System.out.println("1. Login");
	        	System.out.println("2. Register");
	        	System.out.println("3. Salir");
	        	opcion = sc.nextInt();
	        	if(opcion == 2 || opcion == 1) {
	        		try {
						Menu2(opcion, em, scString);
					} catch (NoSuchAlgorithmException e) {
		
						e.printStackTrace();
					}
	        	}
	        	
	        	
	       
	        }while(opcion == 3);
		

	}
	public static void Menu2(int numero, EntityManager em,Scanner scString ) throws NoSuchAlgorithmException {
		switch (numero) {
		case 1: {
			System.out.println("Introduce el nombre de usuario");
			String nombre = scString.nextLine();
			System.out.println("Introduce la password");
			String password = scString.nextLine();
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] passwordHas = password.getBytes();
			md.update(passwordHas);
			byte[] resumen = md.digest();
			String passwordLogin = new String(resumen);
			
			try {
			    TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.password = :passwordLogin", Usuario.class);
			    query.setParameter("passwordLogin", passwordLogin);
			    Usuario usuario = query.getSingleResult();
			    
			    if (usuario != null ) {
			        System.out.println("Inicio de sesión exitoso");
			    } else {
			        System.out.println("Usuario o contraseña incorrectos");
			    }
			} catch (NoResultException e) {
			    System.out.println("Usuario no encontrado");
			}
			
		}
		break;
		case 2: {
			System.out.println("Introduce el nombre para el usuario");
			String nombre = scString.nextLine();
			System.out.println("Introduce la password");
			String password = scString.nextLine();
			byte[] passwordHash = password.getBytes();
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(passwordHash);
			byte[] resumen = md.digest();
			String log = new String(resumen);
			System.out.println("LOG DE HASH : " + log);
			Usuario u = new Usuario();
			u.setNombre(nombre);
			u.setPassword(log);
			em.getTransaction().begin();;
			em.persist(u);
			em.getTransaction().commit();
			
			
			
		}
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + numero);
		}
	}

}
