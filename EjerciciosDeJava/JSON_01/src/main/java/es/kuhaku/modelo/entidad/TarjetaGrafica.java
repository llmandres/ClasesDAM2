package es.kuhaku.modelo.entidad;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class TarjetaGrafica {
    private String marca;
    private String modelo;
    private int cudas;

}
