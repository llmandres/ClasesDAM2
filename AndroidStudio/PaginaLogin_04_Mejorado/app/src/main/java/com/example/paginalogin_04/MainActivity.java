package com.example.paginalogin_04;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.paginalogin_04.modelo.entidad.Pizza;
import com.example.paginalogin_04.modelo.entidad.Usuario;
import com.example.paginalogin_04.modelo.negocio.GestorUsuario;

public class MainActivity extends AppCompatActivity {
    GestorUsuario gu = new GestorUsuario();
    public final static String K_USUARIO = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1 = findViewById(R.id.nombreUsuario);

        EditText e2 = findViewById(R.id.passwordUsuario);

        Button login = findViewById(R.id.login);

        login.setOnClickListener(view -> {
            Log.i("MainActivity", "Login button clicked");
            String nombreUsuario = e1.getText().toString();
            String passwordUsuario = e2.getText().toString();
            Usuario u1 = new Usuario(nombreUsuario, passwordUsuario);
            Intent intent = new Intent(MainActivity.this,Pizzeria.class);
            try {
                if(gu.logearse(u1) == 1){
                    intent.putExtra(K_USUARIO, u1);
                    startActivity(intent);

                }else {

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

    }
}