package es.kuhaku.modelo.entidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Ordenador {
    private String nombre;
    private int precio;
    @Autowired
    private Procesador procesador;
    @Autowired
    private PlacaBase placaBase;
    @Autowired
    private List<Ram> rams;
    @Autowired
    private DiscoDuro discoDuro;
    @Autowired
    private FuenteAlimentacion fuenteAlimentacion;
    @Autowired
    private TarjetaGrafica tarjetaGrafica;
    @Autowired
    private List<Periferico> perifericos;

}
