package com.example.paginalogin_04.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {
    private String tamanio;
    private List<String> listaIngredientes;
    private double precio;


    public String getTamanio() {
        return tamanio;
    }

    public List<String> getListaIngredientes() {
        return listaIngredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public void setListaIngredientes(List<String> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tamaño Pizza = " + tamanio + "\n" +
                "Lista Ingredientes = " + listaIngredientes + "\n" +
                "Precio = " + precio;
    }
}
