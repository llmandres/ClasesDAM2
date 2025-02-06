package es.kuhaku.modelo.entidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Component
@Data
@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String titulo;
	private double precio;
	@ManyToOne
	@JoinColumn(name="fk_id_editorial", referencedColumnName="id")
	private Editorial editorial;
	@ManyToOne
	@JoinColumn(name="fk_id_autor", referencedColumnName="id")
	private Autor autor;

}
