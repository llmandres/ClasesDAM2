package es.kuhaku.modelo.entidad;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PlacaBase {
	    private String modelo;
	    private String marca;
	    private int slotsRam;


	}



