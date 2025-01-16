package es.kuhaku.modelo.entidad;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FuenteAlimentacion {
    private String marca;
    private String modelo;
    private int potencia;  
}

