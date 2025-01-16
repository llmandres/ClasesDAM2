package com.example.recycleviewej.entidad;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class listaJuegos {
    private static listaJuegos instance;
    private List<Juego> listaJuegos;
    private int contador = 1;

    private listaJuegos(){
        super();
    }

    public static listaJuegos getInstance() {
        if(instance == null){
            instance = new listaJuegos();
        }
        return instance;
    }
    public void inicializar(){
        listaJuegos = new ArrayList<>();
        Juego juego = new Juego();
        juego.setId(contador++);
        juego.setNombre("League of Legends");
        juego.setCompania("Riot Games");

        listaJuegos.add(juego);

        juego = new Juego();
        juego.setId(contador++);
        juego.setNombre("Minecraft");
        juego.setCompania("Mojang");


        listaJuegos.add(juego);

        juego = new Juego();
        juego.setId(contador++);
        juego.setNombre("Persona 5");
        juego.setCompania("Atlus");
        listaJuegos.add(juego);

        Log.i("ListaUsuarioSingleton", "########" + listaJuegos);
    }
    public List<Juego> getListaJuegos() {

        return listaJuegos;
    }
    public void borrar(Juego juego){
        listaJuegos.remove(juego);
    }
    public void agregarJuego(String nombre, String compania) {

        Juego nuevoJuego = new Juego();
        nuevoJuego.setId(contador++);
        nuevoJuego.setNombre(nombre);
        nuevoJuego.setCompania(compania);


        listaJuegos.add(nuevoJuego);


        Log.i("ListaUsuarioSingleton", "Juego agregado: " + nuevoJuego);
    }
}
