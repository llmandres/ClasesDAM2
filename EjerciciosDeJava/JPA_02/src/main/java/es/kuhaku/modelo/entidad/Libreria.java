package es.kuhaku.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "librerias")
public class Libreria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String nombreDueno;
    private String direccion;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) 
    private List<Libro> listaLibros;


    public Libreria() {
    }

    public Libreria(String nombre, String nombreDueno, String direccion) {
        this.nombre = nombre;
        this.nombreDueno = nombreDueno;
        this.direccion = direccion;
    }
}
