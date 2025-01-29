package es.kuhaku.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import es.kuhaku.entidad.Videojuego;
import es.kuhaku.modelo.interfaces.DaoInterface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoVideojuego implements DaoInterface {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestServ");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Override
    public boolean agregarVideojuego(Videojuego v) {
        try {
            tx.begin();
            em.persist(v);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarVideojuegoPorId(int id) {
        try {
            tx.begin();
            Videojuego v = em.find(Videojuego.class, id);
            if (v != null) {
                em.remove(v);
                tx.commit();
                return true;
            }
            tx.commit();
            return false;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modificarVideojuegoPorId(int id, Videojuego v) {
        try {
            tx.begin();
            Videojuego videojuegoExistente = em.find(Videojuego.class, id);
            if (videojuegoExistente != null) {
                videojuegoExistente.setNombre(v.getNombre());
                videojuegoExistente.setCompania(v.getCompania());
                videojuegoExistente.setNota(v.getNota());
                em.merge(videojuegoExistente);
                tx.commit();
                return true;
            }
            tx.commit();
            return false;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Videojuego obtenerVideojuegoPorId(int id) {
        try {
            return em.find(Videojuego.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Videojuego> listarTodosLosVideojuegos() {
        try {
            return em.createQuery("SELECT v FROM Videojuego v", Videojuego.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Videojuego> listarVideojuegosPorNombre(String nombre) {
        try {
            return em.createQuery("SELECT v FROM Videojuego v WHERE v.nombre LIKE :nombre", Videojuego.class)
                     .setParameter("nombre", "%" + nombre + "%")
                     .getResultList();
        } catch (Exception e) {
            // Agregar más detalles del error
            System.err.println("Error al listar videojuegos por nombre: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // Retornar una lista vacía si ocurre un error
        }
    }

}

