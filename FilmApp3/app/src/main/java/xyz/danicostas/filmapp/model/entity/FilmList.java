package xyz.danicostas.filmapp.model.entity;

import java.util.List;

public class FilmList {
    private String nombre;
    private List<Pelicula> peliculas;

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
