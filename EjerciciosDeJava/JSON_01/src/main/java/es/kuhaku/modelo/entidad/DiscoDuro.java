package es.kuhaku.modelo.entidad;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class DiscoDuro {
    private String marca;
    private String tipo; 
    private String capacidad; 


}
