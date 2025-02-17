package es.kuhaku;

import java.util.List;

import es.kuhaku.modelo.entidad.Autor;
import es.kuhaku.modelo.entidad.Libreria;
import es.kuhaku.modelo.entidad.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPA02_Consultas {
	public static void main(String[] args) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
	        EntityManager em = emf.createEntityManager();


	        
	        System.out.println("Libros");
	        List<Libro> listaLibros = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
	        
	        for (Libro libro : listaLibros) {
	        	System.out.println("----------------------");
	        	System.out.println(libro.getTitulo());
	        	System.out.println(libro.getPrecio());
	        	System.out.println(libro.getAutor().getNombre());
	        }
	        
	        System.out.println("Autores");
	        List<Autor> listaAutores = em.createQuery("SELECT a FROM Autor a" , Autor.class).getResultList();
	        
	        for(Autor a : listaAutores) {
	        	System.out.println("--------------");
	        	System.out.println(a.getNombre());
	         	System.out.println(a.getApellidos());
	        	for(Libro lib : a.getListaLibros()) {
	        		System.out.println("Libro " + ":" +  lib.getTitulo());
	        	};
	        	System.out.println(a.getFechaNacimiento());
	        }
	        System.out.println("Librerias");
	        List<Libreria> listaLibreria = em.createQuery("SELECT l FROM Libreria l", Libreria.class).getResultList();
	        for (Libreria l : listaLibreria) {
	            System.out.println("Nombre Librería: " + l.getNombre());
	            System.out.println("Nombre del Dueño: " + l.getNombreDueno());
	            System.out.println("Lista de libros:");
	            for (Libro ll : l.getListaLibros()) {
	                System.out.println(" - Libro: " + ll.getTitulo());
	            }
	        }
	        
	        System.out.println("Lista de libros con su Editorial");
	        for (Libro libro : listaLibros) {
	        	System.out.println("----------------------");
	        	System.out.println(libro.getTitulo());
	        	System.out.println(libro.getPrecio());
	        	System.out.println(libro.getEditorial().getNombre());
	        }

		
		
		
	}

}
