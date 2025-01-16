package es.kuhaku.modelo.entidad;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Ram {

	    private String marca;
	    private String tipo;
	    private int capacidad;
	    private int hz;
	    private int cl;

	}


