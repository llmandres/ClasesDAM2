package com.example.paginalogin_04.modelo.persistencia;

import com.example.paginalogin_04.modelo.entidad.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {

    public final static List<Usuario> ARRAY_USUARIOS = new ArrayList<>();
    static {
        ARRAY_USUARIOS.add(new Usuario("Juan", "123", "Calle mayor"));
        ARRAY_USUARIOS.add( new Usuario("Antonio", "1234", "Plaza mayor"));
        ARRAY_USUARIOS.add(new Usuario("Felipe", "12345", "Avenida Flores"));
    }

    public boolean login(Usuario u) {
        for (Usuario user : ARRAY_USUARIOS) {
            if (user != null && user.equals(u)) {
                return true;
            }
        }
        return false;
    }
    public boolean register(Usuario u) {
        if(u != null){
            ARRAY_USUARIOS.add(u);
            return true;
        }
        return false;
    }

}
