package com.example.paginalogin_04;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.paginalogin_04.modelo.entidad.Usuario;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Retrieve data from Intent
        Usuario usuario = (Usuario) getIntent().getSerializableExtra(MainActivity.K_USUARIO2);

        String tamanio = getIntent().getStringExtra("tamanio");
        double precio = getIntent().getDoubleExtra("PRECIO", -1);
        ArrayList<String> ingredientes = getIntent().getStringArrayListExtra("ingredientes");

        TextView textViewNombreUsuario = findViewById(R.id.textViewNombreUsuario);
        TextView textViewDireccion = findViewById(R.id.textViewDireccion);
        TextView textViewPrecio = findViewById(R.id.textViewPrecio);

        textViewNombreUsuario.setText("Nombre de usuario : " + usuario.getNombre());
        textViewDireccion.setText("Direccion : " + usuario.getDireccion());
        textViewPrecio.setText(usuario.getPizza().toString());
    }

    }
