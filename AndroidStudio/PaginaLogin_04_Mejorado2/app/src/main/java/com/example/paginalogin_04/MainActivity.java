package com.example.paginalogin_04;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
    public final static String K_USUARIO2 = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1 = findViewById(R.id.nombreUsuario);

        EditText e2 = findViewById(R.id.passwordUsuario);

        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);

        final ActivityResultLauncher<Intent> activityForResultLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            if (result.getResultCode() == DarAlta.OK) {
                                Intent intent = result.getData();
                                Usuario u2 = (Usuario) intent.getSerializableExtra(DarAlta.K_USUARIO);
                                Toast.makeText(this, "Usuario: " + u2, Toast.LENGTH_SHORT).show();
                                e1.setText(u2.getNombre());
                                e2.setText(u2.getPassword());
                            } else {
                                Toast.makeText(this, "Algun campo de usuario vacio", Toast.LENGTH_SHORT).show();
                                e1.setText("");
                                e2.setText("");
                            }
                        }
                );

        login.setOnClickListener(view -> {
            Log.i("MainActivity", "Login button clicked");
            String nombreUsuario = e1.getText().toString();
            String passwordUsuario = e2.getText().toString();
            Usuario u2 = new Usuario(nombreUsuario, passwordUsuario);
            Intent intent = new Intent(MainActivity.this,Pizzeria.class);
            try {
                if(gu.logearse(u2) == 1){
                    intent.putExtra(K_USUARIO2, u2);
                    startActivity(intent);

                }else {

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        register.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,DarAlta.class);
            activityForResultLauncher.launch( intent);
        });

    }
}