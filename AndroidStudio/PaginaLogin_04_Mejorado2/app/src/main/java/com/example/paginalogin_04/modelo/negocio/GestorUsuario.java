package com.example.paginalogin_04.modelo.negocio;

import android.widget.Toast;

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
    public int register(Usuario u){
        if(u.getNombre().equals("") || u.getPassword().equals("")){
            return 0;
        }else{
            da.register(u);
            return 1;
        }
    }
}
