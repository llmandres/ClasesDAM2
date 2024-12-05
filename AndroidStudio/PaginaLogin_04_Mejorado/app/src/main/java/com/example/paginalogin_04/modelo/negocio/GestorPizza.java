package com.example.paginalogin_04.modelo.negocio;

import android.util.Log;

import com.example.paginalogin_04.modelo.entidad.Pizza;

import java.util.List;

public class GestorPizza {

    public double calcularPrecio(Pizza pizza) {
        double precioTotal = 0.0;

        switch (pizza.getTamanio()) {
            case "Grande":
                precioTotal += 15;
                break;
            case "Mediana":
                precioTotal += 10;
                break;
            case "Pequeña":
                precioTotal += 5;
                break;
            default:
                Log.i("GestorPizza", "Tamaño de Pizza no Valido");
        }
        List<String> ingredientes = pizza.getListaIngredientes();
        if (ingredientes != null) {
            precioTotal += ingredientes.size() * 2;
        }
        pizza.setPrecio(precioTotal);

        return precioTotal;
    }
}
