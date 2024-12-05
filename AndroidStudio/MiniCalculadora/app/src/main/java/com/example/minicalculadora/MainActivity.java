package com.example.minicalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1 = findViewById(R.id.numero1);
        EditText e2 = findViewById(R.id.numero2);
        Button sumar = findViewById(R.id.sumar);
        Button restar = findViewById(R.id.restar);
        Button dividir= findViewById(R.id.dividir);
        Button multiplicar = findViewById(R.id.multiplicar);
        Button potencia = findViewById(R.id.potencia);
        Button borrar = findViewById(R.id.borrar);
        TextView resultado = findViewById(R.id.resultado);



        sumar.setOnClickListener(view -> {
            if(e1.getText().toString() == "" || e2.getText().toString().equals("")){
                resultado.setText("Introduce los valores primero");
            }else {
                double numero1 = Double.parseDouble(e1.getText().toString());
                double numero2 = Double.parseDouble(e2.getText().toString());
                double suma = numero1 + numero2;
                String operacion = String.valueOf(suma);
                resultado.setText(operacion);
            }
                });
        restar.setOnClickListener(view -> {
            if(e1.getText().toString() == "" || e2.getText().toString().equals("")){
                resultado.setText("Introduce los valores primero");
            }else {
                double numero1 = Double.parseDouble(e1.getText().toString());
                double numero2 = Double.parseDouble(e2.getText().toString());
                double resta = numero1 - numero2;
                String operacion = String.valueOf(resta);
                resultado.setText(operacion);
            }
        });
        dividir.setOnClickListener(view -> {
            if(e1.getText().toString() == "" || e2.getText().toString().equals("")){
                resultado.setText("Introduce los valores primero");
            }else {
                double numero1 = Double.parseDouble(e1.getText().toString());
                double numero2 = Double.parseDouble(e2.getText().toString());
                double division = numero1 / numero2;
                String operacion = String.valueOf(division);
                resultado.setText(operacion);
            }
        });
        multiplicar.setOnClickListener(view -> {
            if(e1.getText().toString() == "" || e2.getText().toString().equals("")){
                resultado.setText("Introduce los valores primero");
            }else {
                double numero1 = Double.parseDouble(e1.getText().toString());
                double numero2 = Double.parseDouble(e2.getText().toString());
                double mutliplicacion = numero1 * numero2;
                String operacion = String.valueOf(mutliplicacion);
                resultado.setText(operacion);
            }
        });
        potencia.setOnClickListener(view -> {
            if(e1.getText().toString() == "" || e2.getText().toString().equals("")){
                resultado.setText("Introduce los valores primero");
            }else {
                double numero1 = Double.parseDouble(e1.getText().toString());
                double numero2 = Double.parseDouble(e2.getText().toString());
                double potenciaoperacion = Math.pow(numero1, numero2);
                String operacion = String.valueOf(potenciaoperacion);
                resultado.setText(operacion);
            }
        });
        borrar.setOnClickListener(view -> {
            e1.setText("");
            e2.setText("");
            resultado.setText("0");

        });
    }

}