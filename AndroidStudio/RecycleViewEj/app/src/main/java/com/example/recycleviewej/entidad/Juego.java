package com.example.recycleviewej.entidad;

public class Juego {
    private String nombre;
    private String compania;
    private int id;




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", compania='" + compania + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
