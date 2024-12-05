package com.example.paginalogin_04;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.paginalogin_04.modelo.entidad.Usuario;
import com.example.paginalogin_04.modelo.negocio.GestorUsuario;

public class DarAlta extends AppCompatActivity {
    public static final int OK = 0;
    public static final int KO = 1;

    GestorUsuario gu = new GestorUsuario();
    public final static String K_USUARIO = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_dar_alta);
        super.onCreate(savedInstanceState);
        EditText e1 = findViewById(R.id.nombreUsuarioRegister);
        EditText e2 = findViewById(R.id.passwordUsuarioRegister);
        Button register = findViewById(R.id.registervolver);

        register.setOnClickListener(view -> {
            String nombreUsuario = e1.getText().toString();
            String passwordUsuario = e2.getText().toString();


            if (nombreUsuario.isEmpty() || passwordUsuario.isEmpty()) {
                Toast.makeText(DarAlta.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            Usuario u1 = new Usuario(nombreUsuario, passwordUsuario);
            Intent data = new Intent();

            try {

                if (gu.register(u1) == 1) {
                    data.putExtra(K_USUARIO, u1);
                    setResult(OK, data);
                    Log.v("DarAlta", "Usuario registrado: " + nombreUsuario);
                } else {
                    setResult(KO);
                    Toast.makeText(DarAlta.this, "Ha ocurrido un error durante el registro", Toast.LENGTH_SHORT).show();
                    Log.v("DarAlta", "Ha ocurrido un error");
                }
            } catch (Exception e) {

                Log.e("DarAlta", "Error al registrar el usuario: " + e.getMessage());
                Toast.makeText(DarAlta.this, "Ha ocurrido un error. Inténtelo nuevamente.", Toast.LENGTH_SHORT).show();
                setResult(KO);
            } finally {
                finish();
            }
        });
    }
}
