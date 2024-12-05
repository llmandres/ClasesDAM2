package com.example.paginalogin_04.modelo.persistencia;

import com.example.paginalogin_04.modelo.entidad.Usuario;

public class DaoUsuario {

    public final static Usuario[] ARRAY_USUARIOS = new Usuario[3];
    static {
        ARRAY_USUARIOS[0] = new Usuario("Juan", "123", "Calle mayor");
        ARRAY_USUARIOS[1] = new Usuario("Antonio", "1234", "Plaza mayor");
        ARRAY_USUARIOS[2] = new Usuario("Felipe", "12345", "Avenida Flores");
    }

    public boolean login(Usuario u) {
        for (Usuario user : ARRAY_USUARIOS) {
            if (user != null && user.equals(u)) {
                return true;
            }
        }
        return false;
    }

}
