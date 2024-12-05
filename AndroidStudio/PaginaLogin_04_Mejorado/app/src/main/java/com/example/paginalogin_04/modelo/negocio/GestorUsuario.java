package com.example.paginalogin_04.modelo.negocio;

import com.example.paginalogin_04.modelo.entidad.Usuario;
import com.example.paginalogin_04.modelo.persistencia.DaoUsuario;

public class GestorUsuario {
    private DaoUsuario da = new DaoUsuario();

    public int logearse (Usuario u) throws Exception {
        if (da.login(u)) {
            return 1;
        } else {
            return 0;
        }
    }
}
