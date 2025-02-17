package es.kuhaku.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import lombok.Data;

@Entity
@Data
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private double precio;

    @ManyToOne(cascade = CascadeType.PERSIST) 
    @JoinColumn(name = "fk_id_editorial", referencedColumnName = "id")
    private Editorial editorial;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) 
    @JoinColumn(name = "fk_id_autor", referencedColumnName = "id")
    private Autor autor;


    public Libro() {
    }


    public Libro(Long id, String titulo, double precio, Editorial editorial, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.editorial = editorial;
        this.autor = autor;
    }

 
    public Libro(String titulo, double precio, Editorial editorial, Autor autor) {
        this.titulo = titulo;
        this.precio = precio;
        this.editorial = editorial;
        this.autor = autor;
    }
}
