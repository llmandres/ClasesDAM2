package es.kuhaku.modelo.entidad;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Periferico {
    private String tipo; 
    private String nombre;
    private String marca;


}

