package com.example.calculadoraconstraint;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public final static String U_NOMBRE = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1 = findViewById(R.id.nombre);
        Button b1 = findViewById(R.id.Gnombre);



        b1.setOnClickListener(view -> {
            String nombre = e1.getText().toString();
            if (!nombre.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, Calculadora.class);
                intent.putExtra(U_NOMBRE, nombre);
                startActivity(intent);
            } else {
                e1.setError("Introduce un nombre");
            }

        });



    }
}